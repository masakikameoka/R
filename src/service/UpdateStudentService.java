package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.Student;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * ���k�̍X�V�������Ȃ��N���X
 *
 * @author masaki
 *
 */
public class UpdateStudentService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// ���͂��ꂽ�l�������k�I�u�W�F�N�g
		Student studentForm = (Student) contents
				.get(ActionToServiceDataTransferMapKeyConstants.STUDENT);

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());

		String result = null;

		try {
			/* �ڑ� */

			Dao.connect();

			/* �g�����U�N�V�����̊J�n */
			Dao.beginTransaction();

			Student student = studentDao.load(Student.class,
					studentForm.getStudentId());

			student.setFirstName(studentForm.getFirstName());
			student.setFirstNameKana(studentForm.getFirstNameKana());
			student.setLastName(studentForm.getLastName());
			student.setLastNameKana(studentForm.getLastNameKana());
			student.setRemarks(studentForm.getRemarks());
			// �X�V�������Z�b�g
			student.setUpdateTime(studentForm.getUpdateTime());

			studentDao.updateContent(student);

			/* �R�~�b�g */
			Dao.commit();

			result = Message.UPDATE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// ����ɏ������I�����Ȃ������ꍇ

			// ���[���o�b�N
			Dao.rollback();

			throw new RuntimeException(Message.UPDATE_FAILD_MESSAGE);

		} finally {

			/* �f�[�^�x�[�X�Ƃ̐ڑ���ؒf */
			Dao.sessionClose();
		}

		return result;
	}
}
