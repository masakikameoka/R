package service;

import java.util.Date;
import java.util.Map;

import message.Message;

import org.apache.commons.lang3.math.NumberUtils;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * �N���X���̍폜���s���N���X
 *
 * @author masaki
 *
 */
public class DeleteClassInfoService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// �N���X���ID���擾
		String classInfoIdStr = (String) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID);
		int classInfoId = NumberUtils.createInteger(classInfoIdStr);

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		try {

			// �f�[�^�x�[�X�֐ڑ�
			Dao.connect();

			// �g�����U�N�V�����̊J�n
			Dao.beginTransaction();

			// �������̎�L�[�̒l�ƈ�v����s���擾
			ClassInfo classInfo = classInfoDao.load(ClassInfo.class,
					classInfoId);

			// ���݂̎������擾
			Date sysdate = new Date();

			// �X�V�������Z�b�g
			classInfo.setUpdateTime(sysdate);

			// �_���폜�̎��s
			classInfoDao.delete(classInfo);

			// �R�~�b�g
			Dao.commit();

			// ���ʂ��i�[
			result = Message.DELETE_SUCESS_MESSAGE;
		} catch (Exception e) {

			// ����ɍ폜�o���Ȃ������ꍇ

			// ���[���o�b�N
			Dao.rollback();

			throw new RuntimeException(Message.DELETEA_FAILD_MESSAGE);

		}

		return result;
	}

}
