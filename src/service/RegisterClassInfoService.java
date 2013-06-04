package service;

import java.util.Date;
import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * クラス情報を登録するクラス
 *
 * @author masaki
 *
 */
public class RegisterClassInfoService implements Service {

	public Object execute(Map<String, Object> contents) {

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> dao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// 登録するクラス情報を取得
		ClassInfo content = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		// 現在の時刻を取得
		Date sysdate = new Date();
		/* パラメータをセット */
		content.setCreateTime(sysdate);
		content.setUpdateTime(sysdate);

		// 結果を格納する変数
		Object result = null;
		try {
			// データベースに接続
			Dao.connect();

			// トランザクションの開始
			Dao.beginTransaction();

			// 新規クラス情報を登録
			dao.entryContent(content);

			// 結果を格納
			result = Message.CREATE_SUCSESS_MESSAGE;

			// コミット
			Dao.commit();

		} catch (Exception e) {

			// 正常に登録出来なかった場合

			// ロールバック
			Dao.rollback();

			throw new RuntimeException(Message.CREATE_FAILD_MESSAGE);

		} finally {

			// データベースとの接続を切断
			Dao.sessionClose();
		}
		return result;
	}
}
