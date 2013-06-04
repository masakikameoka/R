package dao;

import org.hibernate.criterion.Example;

import bean.ClassInfo;
import bean.DeleteFlg;
import convert.Convertor;

/**
 * �N���X����CRUD���s���N���X
 *
 * @author masaki
 *
 */
public class ClassInfoDao extends Dao<ClassInfo> {

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	public void addQuery(ClassInfo content) {

		// �󕶎����NULL�ɕϊ�����
		Convertor.convertBlankStringToNull(content);

		// ����������ǉ�
		criteria.add(Example.create(content));
	}

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(ClassInfo content) {

		// �폜�t���O�𗧂Ă�
		content.setDeleteFlg(DeleteFlg.DELETED);

		// �_���폜���s��
		this.updateContent(content);

	}

}
