package service;

import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 *
 * �N���X���̃v���t�B�[�����擾����N���X
 *
 * @author masaki
 *
 */
public class GetClassInfoProfileService implements Service {

	/*
	 * (�� Javadoc)
	 *
	 * @see service.Service#execute(java.util.Map)
	 */
	public Object execute(Map<String, Object> contents) {

		// �N���X���ID���擾
		String classInfoIdStr = (String) contents.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID);
		int classInfoId = NumberUtils.createInteger(classInfoIdStr);

		// ���ʂ��i�[����ϐ�
		Object result = null;

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());
		try {

			// �f�[�^�x�[�X�֐ڑ�
			Dao.connect();

			// ���������s���A���ʂ��i�[
			result = classInfoDao.load(ClassInfo.class, classInfoId);

		} catch (Exception e) {

			// ����Ɏ擾�ł��Ȃ������ꍇ

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);
		}
		return result;
	}

}
