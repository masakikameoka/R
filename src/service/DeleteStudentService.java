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
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* ���kID���擾 */
		String studentIdStr = (String) contents
				.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID);
		int studentId = NumberUtils.createInteger(studentIdStr);

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());
		Dao<PromotionHistory> historyDao = DaoFactory
				.<PromotionHistory> getInstance(DaoNames.PromotionHistoryDao
						.getDaoName());

		// ���ʂ��i�[����
		String result = null;
		try {
			/* �f�[�^�x�[�X�Ɛڑ� */
			Dao.connect();

			// �������̒l����L�[�Ɏ��s���擾
			Student student = studentDao.load(Student.class, studentId);

			/* �g�����U�N�V�������J�n */
			Dao.beginTransaction();

			/* �_���폜�̎��s */
			studentDao.delete(student);
			historyDao.deleteContent(student.getHistory());

			// �R�~�b�g
			Dao.commit();

			// ���ʂ��i�[
			result = Message.DELETE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// ����ɍ폜�o���Ȃ������ꍇ

			// ���[���o�b�N
			Dao.rollback();

			throw new RuntimeException(Message.DELETEA_FAILD_MESSAGE);

		} finally {

			// �f�[�^�x�[�X�Ƃ̐ڑ���ؒf

			Dao.sessionClose();
		}
		return result;
	}

}
