package dao;

import org.hibernate.criterion.Example;

import bean.DeleteFlg;
import bean.Student;
import convert.Convertor;

/**
 * 生徒のCRUDを行うクラス
 *
 * @author masaki
 *
 */
public class StudentDao extends Dao<Student> {

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#entryContent(java.lang.Object)
	 */
	public void entryContent(Student content) {
		// データを挿入
		getSession().save(content);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Student content) {

		// 論理削除フラグを立てる
		content.setDeleteFlg(DeleteFlg.DELETED);

		// 論理削除の実行
		this.updateContent(content);

	}

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	@Override
	public void addQuery(Student student) {

		// 空文字列をnullに変換
		Convertor.convertBlankStringToNull(student);

		// 検索条件を追加
		criteria.add(Example.create(student));

	}

}
