package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * クラス情報の検索を行うアクション
 *
 * @author masaki kameoka
 *
 */
public class SearchClassInfoService implements Service {

	public Object execute(Map<String, Object> contents) {

		// 入力された値が格納されたオブジェクトを取得
		ClassInfo classInfo = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// 結果を格納するクラス
		Object result = null;

		try {
			// データベースへ接続
			Dao.connect();

			classInfoDao.initCriteria(ClassInfo.class);
			// 検索の実行
			classInfoDao.addQuery(classInfo);

			result = classInfoDao.getList();
		} catch (Exception e) {

			// 正常に取得できなかった場合

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);

		} finally {
			// 切断する
			Dao.sessionClose();
		}

		return result;
	}

}
