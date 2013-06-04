package convert;

import org.apache.commons.lang3.StringUtils;

import bean.ClassInfo;
import bean.PromotionHistory;
import bean.Student;
import bean.StudentStatus;

/**
 * bean�̃v���p�e�B�l��ϊ�����N���X
 *
 * @author masaki kameoka
 *
 */
public class Convertor {

	/**
	 * Student�N���X�̃v���p�e�B��NULL�܂��͋󕶎��񂪓����Ă���ꍇ��NULL�ő������
	 *
	 * @param student
	 */
	public static void convertBlankStringToNull(Student student) {

		if (!StringUtils.isNotBlank(student.getFirstName())) {
			// �������͂���Ă��Ȃ��ꍇ
			student.setFirstName(null);
		}
		if (!StringUtils.isNotBlank(student.getFirstNameKana())) {

			// ���̃t���K�i�����͂���Ă����ꍇ
			student.setFirstNameKana(null);
		}
		if (!StringUtils.isNotBlank(student.getLastName())) {

			// �������͂���Ă����ꍇ
			student.setLastName(null);

		}
		if (!StringUtils.isNotBlank(student.getLastNameKana())){

			// ���̃t���K�i�������͂���Ă����ꍇ
			student.setLastNameKana(null);

		}
		if (!StringUtils.isNotBlank(student.getSex())) {

			// ���l�����͂���Ă����ꍇ
			student.setSex(null);

		}
	}

	/**
	 * ClassInfo�N���X�̃v���p�e�B��NULL�܂��͋󕶎��񂪓����Ă���ꍇ��NULL�ő������
	 *
	 * @param classInfo
	 */

	public static void convertBlankStringToNull(ClassInfo classInfo) {

		if (!StringUtils.isNotBlank(classInfo.getClassName())) {
			// �N���X�������͂���Ă��Ȃ��ꍇ
			classInfo.setClassName(null);
		}
		if (!StringUtils.isNotBlank(classInfo.getGrade())) {

			// ���̃t���K�i�����͂���Ă����ꍇ
			classInfo.setGrade(null);
		}

	}

	/**
	 * PromotionHistory�N���X�̃v���p�e�B��NULL�܂��͋󕶎��񂪓����Ă���ꍇ��NULL�ő������
	 *
	 * @param promotionHistory
	 */
	public static void convertBlankStringToNull(
			PromotionHistory promotionHistory) {

		/* �N���X���I�u�W�F�N�g����l�����o�� */
		Student student = promotionHistory.getStudent();
		String fiscalYear = promotionHistory.getFiscalYear();
		ClassInfo classInfo = promotionHistory.getClassInfo();

		if (student != null) {

			// ���k���NULL�ł͂Ȃ��ꍇ
			convertBlankStringToNull(student);

		}
		if (!StringUtils.isNotBlank(fiscalYear)) {

			// �N�x��NULL�܂��͋󕶎���ȏꍇ
			promotionHistory.setFiscalYear(null);

		}
		if (classInfo != null) {

			// �N���X���NULL����Ȃ��ꍇ
			convertBlankStringToNull(classInfo);

		}
	}

	/**
	 * StudentStatus�N���X�̃v���p�e�B��NULL�܂��͋󕶎��񂪓����Ă���ꍇ��NULL��������
	 *
	 * @param studentStatus
	 */
	public static void convertBlankStringToNull(StudentStatus studentStatus) {

		if (!StringUtils.isNotBlank(studentStatus.getFirstName())) {

			// �����Z�b�g����Ă���ꍇ
			studentStatus.setFirstName(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getLastName())) {

			// �����Z�b�g����Ă���ꍇ
			studentStatus.setLastName(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getFirstNameKana())) {

			// ���̃t���K�i���Z�b�g����Ă���ꍇ
			studentStatus.setFirstNameKana(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getLastNameKana())) {

			// ���̃t���K�i���Z�b�g����Ă���ꍇ
			studentStatus.setLastNameKana(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getSex())) {

			// ���ʂ��Z�b�g����Ă���ꍇ
			studentStatus.setSex(null);
		}
		if (!StringUtils.isNotBlank(studentStatus.getClassName())) {

			// �N���X�����Z�b�g����Ă���ꍇ
			studentStatus.setClassName(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getGrade())) {

			// �w�N���Z�b�g����Ă���ꍇ
			studentStatus.setGrade(null);

		}
		if (!StringUtils.isNotBlank(studentStatus.getFiscalYear())) {

			// �i���������Z�b�g����Ă���ꍇ
			studentStatus.setFiscalYear(null);

		}
	}
}
