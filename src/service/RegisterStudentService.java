package service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import message.Message;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import bean.ClassInfo;
import bean.PromotionHistory;
import bean.Student;
import dao.Dao;
import dao.DaoNames;
import factory.DaoFactory;

/**
 *
 * ���k��V�K�o�^����N���X
 *
 * @author masaki
 *
 */
public class RegisterStudentService implements Service {

	public Object execute(Map<String, Object> contents) {

		/* ���Dao�N���X�̃C���X�^���X���擾 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());

		Dao<PromotionHistory> promotionHistoryDao = DaoFactory
				.<PromotionHistory> getInstance(DaoNames.PromotionHistoryDao
						.getDaoName());

		String result = null;

		try {

			// �f�[�^�x�[�X�֐ڑ�
			Dao.connect();

			// �g�����U�N�V�����̊J�n
			Dao.beginTransaction();

			Student student = (Student) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT);

			// ���k����}��
			studentDao.entryContent(student);

			ClassInfo classInfo = (ClassInfo) contents
					.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

			// ���͂��ꂽ�N���X���Ɗw�N���������N���X�^�C�v�I�u�W�F�N�g���擾
			classInfoDao.initCriteria(ClassInfo.class);
			classInfoDao.addQuery(classInfo);
			List<ClassInfo> list = (List<ClassInfo>) classInfoDao.getList();

			classInfo = list.get(0);

			PromotionHistory promotionHistory = (PromotionHistory) contents
					.get(ActionToServiceDataTransferMapKeyConstants.PROMOTION_HISTORY);

			// ���݂̓������Z�b�g
			Date sysdate = new Date();
			classInfo.setCreateTime(sysdate);
			classInfo.setUpdateTime(sysdate);
			promotionHistory.setCreateTime(sysdate);
			promotionHistory.setUpdateTime(sysdate);
			student.setCreateTime(sysdate);
			student.setUpdateTime(sysdate);

			/* ���������Z�b�g */
			promotionHistory.setClassInfo(classInfo);
			promotionHistory.setStudent(student);

			// ��������}��
			promotionHistoryDao.entryContent(promotionHistory);

			/* �R�~�b�g */
			Dao.commit();

			// ���ʂ��i�[
			result = Message.CREATE_SUCSESS_MESSAGE;

		} catch (Exception e) {

			// ����ɓo�^�ł��Ȃ������ꍇ

			/* ���[���o�b�N */
			Dao.rollback();

			throw new RuntimeException(Message.CREATE_FAILD_MESSAGE);

		} finally {

			/* �f�[�^�x�[�X�Ƃ̐ڑ���ؒf */

			Dao.sessionClose();

		}

		return result;
	}
}
