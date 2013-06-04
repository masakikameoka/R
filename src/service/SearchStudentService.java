package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.StudentStatus;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * 生徒の検索を行うクラス
 *
 * @author masaki
 *
 */
public class SearchStudentService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<StudentStatus> dao = DaoFactory
				.<StudentStatus> getInstance(DaoNames.StudentStatusDao.getDaoName());

		// 検索結果を格納する
		Object result = null;

		try {

			// データベースへ接続
			Dao.connect();

			// 入力されたデータを持つオブジェクトを取得
			StudentStatus studentStatus = (StudentStatus) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_STATUS);

			// クライテリアを初期化
			dao.initCriteria(StudentStatus.class);

			// 検索の実行
			dao.addQuery(studentStatus);
			result = dao.getList();

		} catch (Exception e) {

			// 正常に取得できなかった場合

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);

		} finally {

			// データベースとの接続を切断
			Dao.sessionClose();
		}

		return result;
	}
}
