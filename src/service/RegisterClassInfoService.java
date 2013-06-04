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
 * �N���X����o�^����N���X
 *
 * @author masaki
 *
 */
public class RegisterClassInfoService implements Service {

	public Object execute(Map<String, Object> contents) {

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> dao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// �o�^����N���X�����擾
		ClassInfo content = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		// ���݂̎������擾
		Date sysdate = new Date();
		/* �p�����[�^���Z�b�g */
		content.setCreateTime(sysdate);
		content.setUpdateTime(sysdate);

		// ���ʂ��i�[����ϐ�
		Object result = null;
		try {
			// �f�[�^�x�[�X�ɐڑ�
			Dao.connect();

			// �g�����U�N�V�����̊J�n
			Dao.beginTransaction();

			// �V�K�N���X����o�^
			dao.entryContent(content);

			// ���ʂ��i�[
			result = Message.CREATE_SUCSESS_MESSAGE;

			// �R�~�b�g
			Dao.commit();

		} catch (Exception e) {

			// ����ɓo�^�o���Ȃ������ꍇ

			// ���[���o�b�N
			Dao.rollback();

			throw new RuntimeException(Message.CREATE_FAILD_MESSAGE);

		} finally {

			// �f�[�^�x�[�X�Ƃ̐ڑ���ؒf
			Dao.sessionClose();
		}
		return result;
	}
}
