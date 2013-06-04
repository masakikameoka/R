package dao;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import bean.DeleteFlg;
import bean.StudentStatus;
import convert.Convertor;

/**
 * ���k�X�e�[�^�X��CRUD���s��
 *
 * @author masaki kameoka
 *
 */
public class StudentStatusDao extends Dao<StudentStatus> {

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */

	@Override
	public void addQuery(StudentStatus studentStatus) {

		// �󕶎����null�ɕϊ�
		Convertor.convertBlankStringToNull(studentStatus);

		// �_���폜����Ă��Ȃ��s�̂�
		studentStatus.setDeleteFlg(DeleteFlg.NO_DELETED);

		// ����������ǉ�
		criteria.add(Example.create(studentStatus));

		if(studentStatus.getStudentId() != 0){
			criteria.add(Restrictions.eq("studentId", studentStatus.getStudentId()));
		}
	}

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(StudentStatus content) {

		// �_���폜�t���O�𗧂Ă�
		content.setDeleteFlg(DeleteFlg.DELETED);

		// �_���폜�̎��s
		this.updateContent(content);

	}

}
