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
 * 生徒を新規登録するクラス
 *
 * @author masaki
 *
 */
public class RegisterStudentService implements Service {

	public Object execute(Map<String, Object> contents) {

		/* 具象Daoクラスのインスタンスを取得 */
		Dao<ClassInfo> classInfoDao = DaoFactory
				.<ClassInfo> getInstance(DaoNames.ClassInfoDao.getDaoName());

		Dao<Student> studentDao = DaoFactory
				.<Student> getInstance(DaoNames.StudentDao.getDaoName());

		Dao<PromotionHistory> promotionHistoryDao = DaoFactory
				.<PromotionHistory> getInstance(DaoNames.PromotionHistoryDao
						.getDaoName());

		String result = null;

		try {

			// データベースへ接続
			Dao.connect();

			// トランザクションの開始
			Dao.beginTransaction();

			Student student = (Student) contents
					.get(ActionToServiceDataTransferMapKeyConstants.STUDENT);

			// 生徒情報を挿入
			studentDao.entryContent(student);

			ClassInfo classInfo = (ClassInfo) contents
					.get(ActionToServiceDataTransferMapKeyConstants.CLASSINFO);

			// 入力されたクラス名と学年を持ったクラスタイプオブジェクトを取得
			classInfoDao.initCriteria(ClassInfo.class);
			classInfoDao.addQuery(classInfo);
			List<ClassInfo> list = (List<ClassInfo>) classInfoDao.getList();

			classInfo = list.get(0);

			PromotionHistory promotionHistory = (PromotionHistory) contents
					.get(ActionToServiceDataTransferMapKeyConstants.PROMOTION_HISTORY);

			// 現在の日時をセット
			Date sysdate = new Date();
			classInfo.setCreateTime(sysdate);
			classInfo.setUpdateTime(sysdate);
			promotionHistory.setCreateTime(sysdate);
			promotionHistory.setUpdateTime(sysdate);
			student.setCreateTime(sysdate);
			student.setUpdateTime(sysdate);

			/* 履歴情報をセット */
			promotionHistory.setClassInfo(classInfo);
			promotionHistory.setStudent(student);

			// 履歴情報を挿入
			promotionHistoryDao.entryContent(promotionHistory);

			/* コミット */
			Dao.commit();

			// 結果を格納
			result = Message.CREATE_SUCSESS_MESSAGE;

		} catch (Exception e) {

			// 正常に登録できなかった場合

			/* ロールバック */
			Dao.rollback();

			throw new RuntimeException(Message.CREATE_FAILD_MESSAGE);

		} finally {

			/* データベースとの接続を切断 */

			Dao.sessionClose();

		}

		return result;
	}
}
