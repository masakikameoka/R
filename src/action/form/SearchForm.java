package action.form;

import org.apache.struts.action.ActionForm;

/**
 * 検索フォームのデータを扱うフォームクラス
 * @author masaki kameoka
 *
 */

/**
 * @author masaki kameoka
 *
 */
public class SearchForm extends ActionForm {

	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = 1L;

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
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
}
