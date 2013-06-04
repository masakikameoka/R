package service;

import java.util.Map;

import message.Message;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * クラス情報を更新するクラス
 *
 * @author masaki
 *
 */
public class UpdateClassInfoService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> dao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// 結果を格納
		Object result = null;

		// 入力された値を持つオブジェクトを取得
		ClassInfo classInfoForm = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		try {

			// データベースと接続
			Dao.connect();

			// 更新する行のオブジェクトを取得
			ClassInfo classInfo = dao.load(ClassInfo.class,
					classInfoForm.getClassInfoId());

			/* 値をセット */
			classInfo.setClassName(classInfoForm.getClassName());
			classInfo.setGrade(classInfoForm.getGrade());
			classInfo.setUpdateTime(classInfoForm.getUpdateTime());
			// トランザクションを開始
			Dao.beginTransaction();
			// 更新実行
			dao.updateContent(classInfo);

			// コミット
			Dao.commit();

			// 結果を格納
			result = Message.UPDATE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// 正常に更新されなかった場合

			// ロールバック
			Dao.rollback();

			throw new RuntimeException(Message.UPDATE_FAILD_MESSAGE);
		} finally {

			// データベースとの接続を切断
			Dao.sessionClose();

		}
		return result;
	}

}
