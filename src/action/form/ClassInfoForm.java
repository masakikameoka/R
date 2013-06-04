package action.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * �N���X���̃t�H�[���̃f�[�^�������t�H�[���N���X
 *
 * @author masaki kameoka
 *
 */

public class ClassInfoForm extends ValidatorForm {

	/**
	 * �V���A���o�[�W����ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �N���X��
	 */
	private String className;

	/**
	 * �w�N
	 */
	private String grade;

	/**
	 * �N���X�����擾����
	 *
	 * @return �N���X��
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * �N���X�����Z�b�g����
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * �w�N���擾����
	 *
	 * @return �w�N
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * �w�N���Z�b�g����
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
