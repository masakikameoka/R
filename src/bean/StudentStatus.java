package bean;

/**
 * 生徒の状態クラス
 *
 * @author masaki kameoka
 *
 */
public class StudentStatus {

	/**
	 * 生徒ID
	 */
	private int studentId;

	/**
	 * 性
	 */
	private String firstName;

	/**
	 * 性のフリガナ
	 */
	private String firstNameKana;

	/**
	 * 名
	 */
	private String lastName;

	/**
	 * 名のフリガナ
	 */
	private String lastNameKana;

	/**
	 * 生年月日を取得
	 */
	private String birthday;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * クラス名
	 */
	private String className;

	/**
	 * 学年
	 */
	private String grade;

	/**
	 * 年度
	 */
	private String fiscalYear;
	/**
	 * 備考
	 */
	private String remarks;
	/**
	 * 論理削除フラグ
	 */
	private String deleteFlg = DeleteFlg.NO_DELETED;

	/**
	 * 生徒IDを取得
	 *
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * 生徒IDをセット
	 *
	 * @param studentid
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * 性を取得
	 *
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 性をセット
	 *
	 * @param firstName
	 *            セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 性のフリガナを取得
	 *
	 * @return firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}

	/**
	 * 性のフリガナをセット
	 *
	 * @param firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	/**
	 * 名を取得
	 *
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 名をセット
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 名のフリガナを取得
	 *
	 * @return lastNameKana
	 */
	public String getLastNameKana() {
		return lastNameKana;
	}

	/**
	 * 名のフリガナをセット
	 *
	 * @param lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	/**
	 * 生年月日を取得
	 *
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 *
	 * 生年月日をセット
	 *
	 * @param birthday
	 *
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 性別を取得
	 *
	 * @return sex
	 */
	public String getSex() {

		return sex;
	}

	/**
	 * 性別をセット
	 *
	 * @param sex
	 *
	 */
	public void setSex(String sex) {

		this.sex = sex;
	}

	/**
	 * 備考を取得
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 備考をセット
	 *
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 論理削除フラグを取得
	 *
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * クラス名を取得
	 *
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * クラス名をセット
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 学年を取得
	 *
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 学年をセット
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 論理削除フラグをセット
	 *
	 * @param deleteFlg
	 *
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * 年度を取得
	 *
	 * @return fiscalYear
	 */
	public String getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * 年度をセット
	 *
	 * @param fiscalYear
	 */
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	/**
	 * 生徒情報をセットする
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
	 * クラス情報をセット
	 *
	 * @param classType
	 */
	public void setClassTypeValue(ClassInfo classType) {
		this.setClassName(classType.getClassName());
		this.setGrade(classType.getGrade());
	}

}
