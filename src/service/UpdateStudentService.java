package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.Student;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * 生徒の更新をおこなうクラス
 *
 * @author masaki
 *
 */
public class UpdateStudentService implements Service {

	/*
	 * (非 Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// 入力された値を持つ生徒オブジェクト
		Student studentForm = (Student) contents
				.get(ActionToServiceDataTransferMapKeyConstants.STUDENT);

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());

		String result = null;

		try {
			/* 接続 */

			Dao.connect();

			/* トランザクションの開始 */
			Dao.beginTransaction();

			Student student = studentDao.load(Student.class,
					studentForm.getStudentId());

			student.setFirstName(studentForm.getFirstName());
			student.setFirstNameKana(studentForm.getFirstNameKana());
			student.setLastName(studentForm.getLastName());
			student.setLastNameKana(studentForm.getLastNameKana());
			student.setRemarks(studentForm.getRemarks());
			// 更新日時をセット
			student.setUpdateTime(studentForm.getUpdateTime());

			studentDao.updateContent(student);

			/* コミット */
			Dao.commit();

			result = Message.UPDATE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// 正常に処理が終了しなかった場合

			// ロールバック
			Dao.rollback();

			throw new RuntimeException(Message.UPDATE_FAILD_MESSAGE);

		} finally {

			/* データベースとの接続を切断 */
			Dao.sessionClose();
		}

		return result;
	}
}
