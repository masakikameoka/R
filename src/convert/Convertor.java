package convert;

import org.apache.commons.lang3.StringUtils;

import bean.ClassInfo;
import bean.PromotionHistory;
import bean.Student;
import bean.StudentStatus;

/**
 * beanのプロパティ値を変換するクラス
 *
 * @author masaki kameoka
 *
 */
public class Convertor {

	/**
	 * StudentクラスのプロパティにNULLまたは空文字列が入っている場合はNULLで代入する
	 *
	 * @param student
	 */
	public static void convertBlankStringToNull(Student student) {

		if (!StringUtils.isNotBlank(student.getFirstName())) {
			// 性が入力されていない場合
			student.setFirstName(null);
		}
		if (!StringUtils.isNotBlank(student.getFirstNameKana())) {

			// 性のフリガナが入力されていた場合
			student.setFirstNameKana(null);
		}
		if (!StringUtils.isNotBlank(student.getLastName())) {

			// 名が入力されていた場合
			student.setLastName(null);

		}
		if (!StringUtils.isNotBlank(student.getLastNameKana())){

			// 名のフリガナ名が入力されていた場合
			student.setLastNameKana(null);

		}
		if (!StringUtils.isNotBlank(student.getSex())) {

			// 備考が入力されていた場合
			student.setSex(null);

		}
	}

	/**
	 * ClassInfoクラスのプロパティにNULLまたは空文字列が入っている場合はNULLで代入する
	 *
	 * @param classInfo
	 */

	public static void convertBlankStringToNull(ClassInfo classInfo) {

		if (!StringUtils.isNotBlank(classInfo.getClassName())) {
			// クラス名が入力されていない場合
			classInfo.setClassName(null);
		}
		if (!StringUtils.isNotBlank(classInfo.getGrade())) {

			// 性のフリガナが入力されていた場合
			classInfo.setGrade(null);
		}

	}

	/**
	 * PromotionHistoryクラスのプロパティにNULLまたは空文字列が入っている場合はNULLで代入する
	 *
	 * @param promotionHistory
	 */
	public static void convertBlankStringToNull(
			PromotionHistory promotionHistory) {

		/* クラス情報オブジェクトから値を取り出す */
		Student student = promotionHistory.getStudent();
		String fiscalYear = promotionHistory.getFiscalYear();
		ClassInfo classInfo = promotionHistory.getClassInfo();

		if (student != null) {

			// 生徒情報がNULLではない場合
			convertBlankStringToNull(student);

		}
		if (!StringUtils.isNotBlank(fiscalYear)) {

			// 年度がNULLまたは空文字列な場合
			promotionHistory.setFiscalYear(null);

		}
		if (classInfo != null) {

			// クラス情報がNULLじゃない場合
			convertBlankStringToNull(classInfo);

		}
	}

	/**
	 * StudentStatusクラスのプロパティにNULLまたは空文字列が入っている場合はNULLを代入する
	 *
	 * @param studentStatus
	 */
	public static void convertBlankStringToNull(StudentStatus studentStatus) {

		if (!StringUtils.isNotBlank(studentStatus.getFirstName())) {

			// 性がセットされている場合
			studentStatus.setFirstName(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getLastName())) {

			// 名がセットされている場合
			studentStatus.setLastName(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getFirstNameKana())) {

			// 性のフリガナがセットされている場合
			studentStatus.setFirstNameKana(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getLastNameKana())) {

			// 名のフリガナがセットされている場合
			studentStatus.setLastNameKana(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getSex())) {

			// 性別がセットされている場合
			studentStatus.setSex(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getClassName())) {

			// クラス名がセットされている場合
			studentStatus.setClassName(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getGrade())) {

			// 学年がセットされている場合
			studentStatus.setGrade(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getFiscalYear())) {

			// 進級履歴がセットされている場合
			studentStatus.setFiscalYear(null);

		}
	}
}
