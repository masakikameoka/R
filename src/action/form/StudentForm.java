package action.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * 生徒のプロフィールに扱うホーム
 *
 * @author masaki kameoka
 *
 */

public class StudentForm extends ValidatorForm {

	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 生徒ID
	 */
	private int studentid;

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
	 * 生年月日の年
	 */
	private String birthdayYear;

	/**
	 * 生年月日の月
	 */
	private String birthdayMonth;
	/**
	 * 生年月日の日
	 */
	private String birthdayDay;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * 備考
	 */
	private String remarks;

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
	 * 生徒IDを取得
	 *
	 * @return studentId
	 */
	public int getStudentid() {
		return studentid;
	}

	/**
	 * 生徒IDをセット
	 *
	 * @param studentid
	 */
	public void setStudentid(int studentid) {
		this.studentid = studentid;
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
	 * 生年月日の年を取得
	 *
	 * @return birthdayYear
	 */
	public String getBirthdayYear() {
		return birthdayYear;
	}

	/**
	 * 生年月日の年をセット
	 */

	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	/**
	 * 生年月日の月を取得
	 *
	 * @return birthdayMonth
	 */
	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	/**
	 * 生年月日の月をセット
	 */
	public void setBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	/**
	 * 生年月日の日を取得
	 *
	 * @return
	 */
	public String getBirthdayDay() {
		return birthdayDay;
	}

	/**
	 * 生年月日の日をセット
	 *
	 * @param birthdayDay
	 */
	public void setBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	/**
	 * 性別をセット
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

}
