package service;

import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 * �N���X���̌������s���A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class SearchClassInfoService implements Service {

	public Object execute(Map<String, Object> contents) {

		// ���͂��ꂽ�l���i�[���ꂽ�I�u�W�F�N�g���擾
		ClassInfo classInfo = (ClassInfo) contents
				.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		// ���ʂ��i�[����N���X
		Object result = null;

		try {
			// �f�[�^�x�[�X�֐ڑ�
			Dao.connect();

			classInfoDao.initCriteria(ClassInfo.class);
			// �����̎��s
			classInfoDao.addQuery(classInfo);

			result = classInfoDao.getList();
		} catch (Exception e) {

			// ����Ɏ擾�ł��Ȃ������ꍇ

			throw new RuntimeException(Message.READ_FAILD_MESSAGE);

		} finally {
			// �ؒf����
			Dao.sessionClose();
		}

		return result;
	}

}
