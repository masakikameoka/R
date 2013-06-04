package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ���k�N���X
 *
 * @author masaki kameoka
 *
 */
public class Student {

	/**
	 * ���kID
	 */
	private int studentId;

	/**
	 * ��
	 */
	private String firstName;

	/**
	 * ���̃t���K�i
	 */
	private String firstNameKana;

	/**
	 * ��
	 */
	private String lastName;

	/**
	 * ���̃t���K�i
	 */
	private String lastNameKana;

	/**
	 * ���N�������擾
	 */
	private String birthday;

	/**
	 * ����
	 */
	private String sex;

	/**
	 * ���l
	 */
	private String remarks;

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
	 * ���Έ�֘A�̂��߂̐i�������Z�b�g
	 */
	private Set<PromotionHistory> history;

	/**
	 * �i��������ǉ�����
	 *
	 * @param history
	 */
	public void addHistory(PromotionHistory history) {

		if (this.history == null) {

			// �����Z�b�g��null�ȏꍇ
			this.history = new HashSet<PromotionHistory>();
		}

		this.history.add(history);

	}

	/**
	 * �N���X�̐i���������擾
	 *
	 * @return history
	 */
	public Set<PromotionHistory> getHistory() {
		return history;
	}

	/**
	 * �N���X�̐i���������Z�b�g
	 *
	 * @param history
	 */
	public void setHistory(Set<PromotionHistory> history) {
		this.history = history;
	}

	/**
	 * ���kID���擾
	 *
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * ���kID���Z�b�g
	 *
	 * @param studentid
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * �����擾
	 *
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * �����Z�b�g
	 *
	 * @param firstName
	 *            �Z�b�g���� firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * ���̃t���K�i���擾
	 *
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}

	/**
	 * ���̃t���K�i���Z�b�g
	 *
	 * @param firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	/**
	 * �����擾
	 *
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * �����Z�b�g
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * ���̃t���K�i���擾
	 *
	 * @return lastNameKana
	 */
	public String getLastNameKana() {
		return lastNameKana;
	}

	/**
	 * ���̃t���K�i���Z�b�g
	 *
	 * @param lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	/**
	 * ���N�������擾
	 *
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 *
	 * ���N�������Z�b�g
	 *
	 * @param birthday
	 *
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * ���ʂ��擾
	 *
	 * @return sex
	 */
	public String getSex() {

		return sex;
	}

	/**
	 * ���ʂ��Z�b�g
	 *
	 * @param sex
	 *
	 */
	public void setSex(String sex) {

		this.sex = sex;
	}

	/**
	 * ���l���擾
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
