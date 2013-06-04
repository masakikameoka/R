package dao;

import org.hibernate.criterion.Example;

import bean.DeleteFlg;
import bean.Student;
import convert.Convertor;

/**
 * ���k��CRUD���s���N���X
 *
 * @author masaki
 *
 */
public class StudentDao extends Dao<Student> {

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#entryContent(java.lang.Object)
	 */
	public void entryContent(Student content) {
		// �f�[�^��}��
		getSession().save(content);
	}

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Student content) {

		// �_���폜�t���O�𗧂Ă�
		content.setDeleteFlg(DeleteFlg.DELETED);

		// �_���폜�̎��s
		this.updateContent(content);

	}

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	@Override
	public void addQuery(Student student) {

		// �󕶎����null�ɕϊ�
		Convertor.convertBlankStringToNull(student);

		// ����������ǉ�
		criteria.add(Example.create(student));

	}

}
