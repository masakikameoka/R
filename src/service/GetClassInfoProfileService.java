package service;

import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 *
 * クラス情報のプロフィールを取得するクラス
 *
 * @author masaki
 *
 */
public class GetClassInfoProfileService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// クラス情報IDを取得
		String classInfoIdStr = (String) contents.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID);
		int classInfoId = NumberUtils.createInteger(classInfoIdStr);

		// 結果を格納する変数
		Object result = null;

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());
		try {

			// データベースへ接続
			Dao.connect();

			// 検索を実行し、結果を格納
			result = classInfoDao.load(ClassInfo.class, classInfoId);

		} catch (Exception e) {

			// 正常に取得できなかった場合

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);
		}
		return result;
	}

}
