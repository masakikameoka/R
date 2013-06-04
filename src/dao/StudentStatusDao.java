package dao;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import bean.DeleteFlg;
import bean.StudentStatus;
import convert.Convertor;

/**
 * 生徒ステータスのCRUDを行う
 *
 * @author masaki kameoka
 *
 */
public class StudentStatusDao extends Dao<StudentStatus> {

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */

	@Override
	public void addQuery(StudentStatus studentStatus) {

		// 空文字列をnullに変換
		Convertor.convertBlankStringToNull(studentStatus);

		// 論理削除されていない行のみ
		studentStatus.setDeleteFlg(DeleteFlg.NO_DELETED);

		// 検索条件を追加
		criteria.add(Example.create(studentStatus));

		if(studentStatus.getStudentId() != 0){
			criteria.add(Restrictions.eq("studentId", studentStatus.getStudentId()));
		}
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(StudentStatus content) {

		// 論理削除フラグを立てる
		content.setDeleteFlg(DeleteFlg.DELETED);

		// 論理削除の実行
		this.updateContent(content);

	}

}
