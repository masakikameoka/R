/**
 *
 */
package service;

import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import message.Message;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.PromotionHistory;
import bean.Student;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * @author masaki kameoka
 *
 */
public class DeleteStudentService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* 生徒IDを取得 */
		String studentIdStr = (String) contents
				.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID);
		int studentId = NumberUtils.createInteger(studentIdStr);

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());
		Dao<PromotionHistory> historyDao = DaoFactory
				.<PromotionHistory> getInstance(DaoNames.PromotionHistoryDao
						.getDaoName());

		// 結果を格納する
		String result = null;
		try {
			/* データベースと接続 */
			Dao.connect();

			// 第二引数の値を主キーに持つ行を取得
			Student student = studentDao.load(Student.class, studentId);

			/* トランザクションを開始 */
			Dao.beginTransaction();

			/* 論理削除の実行 */
			studentDao.delete(student);
			historyDao.deleteContent(student.getHistory());

			// コミット
			Dao.commit();

			// 結果を格納
			result = Message.DELETE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// 正常に削除出来なかった場合

			// ロールバック
			Dao.rollback();

			throw new RuntimeException(Message.DELETEA_FAILD_MESSAGE);

		} finally {

			// データベースとの接続を切断

			Dao.sessionClose();
		}
		return result;
	}

}
