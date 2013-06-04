package service;

import java.util.Date;
import java.util.Map;

import message.Message;

import org.apache.commons.lang3.math.NumberUtils;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * クラス情報の削除を行うクラス
 *
 * @author masaki
 *
 */
public class DeleteClassInfoService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// クラス情報IDを取得
		String classInfoIdStr = (String) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID);
		int classInfoId = NumberUtils.createInteger(classInfoIdStr);

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// 結果を格納する変数
		Object result = null;

		try {

			// データベースへ接続
			Dao.connect();

			// トランザクションの開始
			Dao.beginTransaction();

			// 第二引数の主キーの値と一致する行を取得
			ClassInfo classInfo = classInfoDao.load(ClassInfo.class,
					classInfoId);

			// 現在の時刻を取得
			Date sysdate = new Date();

			// 更新日時をセット
			classInfo.setUpdateTime(sysdate);

			// 論理削除の実行
			classInfoDao.delete(classInfo);

			// コミット
			Dao.commit();

			// 結果を格納
			result = Message.DELETE_SUCESS_MESSAGE;
		} catch (Exception e) {

			// 正常に削除出来なかった場合

			// ロールバック
			Dao.rollback();

			throw new RuntimeException(Message.DELETEA_FAILD_MESSAGE);

		}

		return result;
	}

}
