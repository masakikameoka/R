package action.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * クラス情報のフォームのデータを扱うフォームクラス
 *
 * @author masaki kameoka
 *
 */

public class ClassInfoForm extends ValidatorForm {

	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * クラス名
	 */
	private String className;

	/**
	 * 学年
	 */
	private String grade;

	/**
	 * クラス名を取得する
	 *
	 * @return クラス名
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * クラス名をセットする
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 学年を取得する
	 *
	 * @return 学年
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 学年をセットする
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
