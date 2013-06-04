package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * �i��������\���N���X
 *
 * @author masaki kameoka
 *
 */
public class PromotionHistory implements Serializable {

	/**
	 * �V���A���o�[�W����ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Α��֘A�̂��߂̐��k�N���X
	 */
	private Student student;

	/**
	 * ��Α��֘A�̂��߂̃N���X���N���X
	 */
	private ClassInfo classInfo;
	/**
	 * �N�x
	 */
	private String fiscalYear;
	/**
	 * �X�V����
	 */
	private Date updateTime;

	/**
	 * �o�^����
	 */
	private Date createTime;

	/**
	 * �_���폜�t���O
	 */
	private String deleteFlg = DeleteFlg.NO_DELETED;

	/**
	 * �i�������ɂ��鐶�k�̏����擾
	 *
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * �i�������ɂ��鐶�k�̏����Z�b�g
	 *
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * �i�������ɂ���N���X�����擾
	 *
	 * @return classinfo
	 */
	public ClassInfo getClassInfo() {
		return classInfo;
	}

	/**
	 * �Ջ������ɂ���N���X�����Z�b�g
	 *
	 * @param classType
	 */
	public void setClassInfo(ClassInfo classType) {
		this.classInfo = classType;
	}

	/**
	 * �N�x���擾
	 *
	 * @return fiscalYear
	 */
	public String getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * �N�x���Z�b�g
	 *
	 * @param fiscalYear
	 */
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	/**
	 * �X�V�������擾
	 *
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * �X�V�������Z�b�g
	 *
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * �o�^�������擾
	 *
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * �X�V�������Z�b�g
	 *
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * �_���폜�t���O���擾
	 *
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * �_���폜�t���O���Z�b�g
	 *
	 * @param deleteFlg
	 *            �Z�b�g���� deleteFlg
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
