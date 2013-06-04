package action.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * ���k�̃v���t�B�[���Ɉ����z�[��
 *
 * @author masaki kameoka
 *
 */

public class StudentForm extends ValidatorForm {

	/**
	 * �V���A���o�[�W����ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���kID
	 */
	private int studentid;

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
	 * ���N�����̔N
	 */
	private String birthdayYear;

	/**
	 * ���N�����̌�
	 */
	private String birthdayMonth;
	/**
	 * ���N�����̓�
	 */
	private String birthdayDay;

	/**
	 * ����
	 */
	private String sex;

	/**
	 * ���l
	 */
	private String remarks;

	/**
	 * �N���X��
	 */
	private String className;

	/**
	 * �w�N
	 */
	private String grade;
	/**
	 * �N�x
	 */
	private String fiscalYear;

	/**
	 * ���kID���擾
	 *
	 * @return studentId
	 */
	public int getStudentid() {
		return studentid;
	}

	/**
	 * ���kID���Z�b�g
	 *
	 * @param studentid
	 */
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	/**
	 * �N���X�����擾
	 *
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * �N���X�����Z�b�g
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * �w�N���擾
	 *
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * �w�N���Z�b�g
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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
	 * ���N�����̔N���擾
	 *
	 * @return birthdayYear
	 */
	public String getBirthdayYear() {
		return birthdayYear;
	}

	/**
	 * ���N�����̔N���Z�b�g
	 */

	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	/**
	 * ���N�����̌����擾
	 *
	 * @return birthdayMonth
	 */
	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	/**
	 * ���N�����̌����Z�b�g
	 */
	public void setBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	/**
	 * ���N�����̓����擾
	 *
	 * @return
	 */
	public String getBirthdayDay() {
		return birthdayDay;
	}

	/**
	 * ���N�����̓����Z�b�g
	 *
	 * @param birthdayDay
	 */
	public void setBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	/**
	 * ���ʂ��Z�b�g
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
	 * ���l���Z�b�g
	 *
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
