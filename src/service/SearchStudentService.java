package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.StudentStatus;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * ���k�̌������s���N���X
 *
 * @author masaki
 *
 */
public class SearchStudentService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<StudentStatus> dao = DaoFactory
				.<StudentStatus> getInstance(DaoNames.StudentStatusDao.getDaoName());

		// �������ʂ��i�[����
		Object result = null;

		try {

			// �f�[�^�x�[�X�֐ڑ�
			Dao.connect();

			// ���͂��ꂽ�f�[�^�����I�u�W�F�N�g���擾
			StudentStatus studentStatus = (StudentStatus) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_STATUS);

			// �N���C�e���A��������
			dao.initCriteria(StudentStatus.class);

			// �����̎��s
			dao.addQuery(studentStatus);
			result = dao.getList();

		} catch (Exception e) {

			// ����Ɏ擾�ł��Ȃ������ꍇ

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);

		} finally {

			// �f�[�^�x�[�X�Ƃ̐ڑ���ؒf
			Dao.sessionClose();
		}

		return result;
	}
}
