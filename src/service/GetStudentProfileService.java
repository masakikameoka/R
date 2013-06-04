package service;

import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.StudentStatus;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * 生徒のプロフィールを取得するクラス
 *
 * @author masaki
 *
 */
public class GetStudentProfileService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<StudentStatus> dao = DaoFactory
				.<StudentStatus> getInstance(DaoNames.StudentStatusDao
						.getDaoName());

		Object result = null;

		try {

			/* 生徒IDを取得 */
			String studentIdStr = (String) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID);
			int studentId = NumberUtils.createInteger(studentIdStr);

			// データベースに接続
			Dao.connect();

			// 現在の年度を取得
			String maxFiscalYear = (String) dao.getMaxValue(
					StudentStatus.class, "fiscalYear", studentId);

			/* 生徒ステータスクラスに値を代入 */

			StudentStatus content = new StudentStatus();
			content.setStudentId(studentId);
			content.setFiscalYear(maxFiscalYear);

			// クライテリアを初期化
			dao.initCriteria(StudentStatus.class);
			// 検索を実行
			dao.addQuery(content);

			// 結果を格納
			result = dao.getList().get(0);

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
