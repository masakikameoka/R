package action.form;

import org.apache.struts.action.ActionForm;

/**
 * �����t�H�[���̃f�[�^�������t�H�[���N���X
 * @author masaki kameoka
 *
 */

/**
 * @author masaki kameoka
 *
 */
public class SearchForm extends ActionForm {

	/**
	 * �V���A���o�[�W����ID
	 */
	private static final long serialVersionUID = 1L;

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
	 * ����
	 */
	private String sex;

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
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
}
