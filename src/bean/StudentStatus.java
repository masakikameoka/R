package bean;

/**
 * ���k�̏�ԃN���X
 *
 * @author masaki kameoka
 *
 */
public class StudentStatus {

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
	 * ���l
	 */
	private String remarks;
	/**
	 * �_���폜�t���O
	 */
	private String deleteFlg = DeleteFlg.NO_DELETED;

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
	 * ���l���Z�b�g
	 *
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * �_���폜�t���O���Z�b�g
	 *
	 * @param deleteFlg
	 *
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
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
	 * ���k�����Z�b�g����
	 *
	 * @param student
	 */
	public void setStudentValue(Student student) {
		this.setFirstName(student.getFirstName());
		this.setLastName(student.getLastName());
		this.setFirstNameKana(student.getFirstNameKana());
		this.setLastNameKana(student.getLastNameKana());
		this.setSex(student.getSex());
		this.setStudentId(student.getStudentId());
	}

	/**
	 * �N���X�����Z�b�g
	 *
	 * @param classType
	 */
	public void setClassTypeValue(ClassInfo classType) {
		this.setClassName(classType.getClassName());
		this.setGrade(classType.getGrade());
	}

}
