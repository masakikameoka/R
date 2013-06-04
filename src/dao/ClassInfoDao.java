package dao;

import org.hibernate.criterion.Example;

import bean.ClassInfo;
import bean.DeleteFlg;
import convert.Convertor;

/**
 * クラス情報のCRUDを行うクラス
 *
 * @author masaki
 *
 */
public class ClassInfoDao extends Dao<ClassInfo> {

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	public void addQuery(ClassInfo content) {

		// 空文字列をNULLに変換する
		Convertor.convertBlankStringToNull(content);

		// 検索条件を追加
		criteria.add(Example.create(content));
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(ClassInfo content) {

		// 削除フラグを立てる
		content.setDeleteFlg(DeleteFlg.DELETED);

		// 論理削除を行う
		this.updateContent(content);

	}

}
