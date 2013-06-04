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
 * ���k�̃v���t�B�[�����擾����N���X
 *
 * @author masaki
 *
 */
public class GetStudentProfileService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<StudentStatus> dao = DaoFactory
				.<StudentStatus> getInstance(DaoNames.StudentStatusDao
						.getDaoName());

		Object result = null;

		try {

			/* ���kID���擾 */
			String studentIdStr = (String) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID);
			int studentId = NumberUtils.createInteger(studentIdStr);

			// �f�[�^�x�[�X�ɐڑ�
			Dao.connect();

			// ���݂̔N�x���擾
			String maxFiscalYear = (String) dao.getMaxValue(
					StudentStatus.class, "fiscalYear", studentId);

			/* ���k�X�e�[�^�X�N���X�ɒl���� */

			StudentStatus content = new StudentStatus();
			content.setStudentId(studentId);
			content.setFiscalYear(maxFiscalYear);

			// �N���C�e���A��������
			dao.initCriteria(StudentStatus.class);
			// ���������s
			dao.addQuery(content);

			// ���ʂ��i�[
			result = dao.getList().get(0);

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
