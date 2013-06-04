package service;

import java.util.Map;

import message.Message;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * �N���X�����X�V����N���X
 *
 * @author masaki
 *
 */
public class UpdateClassInfoService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> dao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// ���ʂ��i�[
		Object result = null;

		// ���͂��ꂽ�l�����I�u�W�F�N�g���擾
		ClassInfo classInfoForm = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		try {

			// �f�[�^�x�[�X�Ɛڑ�
			Dao.connect();

			// �X�V����s�̃I�u�W�F�N�g���擾
			ClassInfo classInfo = dao.load(ClassInfo.class,
					classInfoForm.getClassInfoId());

			/* �l���Z�b�g */
			classInfo.setClassName(classInfoForm.getClassName());
			classInfo.setGrade(classInfoForm.getGrade());
			classInfo.setUpdateTime(classInfoForm.getUpdateTime());
			// �g�����U�N�V�������J�n
			Dao.beginTransaction();
			// �X�V���s
			dao.updateContent(classInfo);

			// �R�~�b�g
			Dao.commit();

			// ���ʂ��i�[
			result = Message.UPDATE_SUCESS_MESSAGE;

		} catch (Exception e) {

			// ����ɍX�V����Ȃ������ꍇ

			// ���[���o�b�N
			Dao.rollback();

			throw new RuntimeException(Message.UPDATE_FAILD_MESSAGE);
		} finally {

			// �f�[�^�x�[�X�Ƃ̐ڑ���ؒf
			Dao.sessionClose();

		}
		return result;
	}

}
