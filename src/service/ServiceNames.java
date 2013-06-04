package service;

/**
 * �T�[�r�X�N���X�̖��O��Enum�N���X
 *
 * @author masaki kameoka
 *
 */
public enum ServiceNames {

	/**
	 * �N���X����o�^����T�[�r�X�N���X��
	 */
	ClassInfoCreateService("ClassInfoCreateService"),

	/**
	 * ���k��o�^����T�[�r�X�N���X��
	 */
	StudentCreateService("StudentCreateService"),

	/**
	 * �N���X������������T�[�r�X�N���X��
	 */
	ClassInfoSearchService("ClassInfoSearchService"),

	/**
	 * ���k����������T�[�r�X�N���X��
	 */
	StudentSearchService("StudentSearchService"),

	/**
	 * ���k���폜����T�[�r�X�N���X��
	 */
	StudentDeleteService("StudentDeleteService"),

	/**
	 * �P�l�̐��k�̏ڍׂ��擾����T�[�r�X�N���X��
	 */
	StudentProfileService("StudentProfileService"),

	/**
	 * ���k���X�V���邷��T�[�r�X�N���X��
	 */
	StudentUpdateService("StudentUpdateService"),

	/**
	 * �N���X�����X�V����T�[�r�X�N���X��
	 */
	ClassInfoUpdateServce("ClassInfoUpdateServce"),

	/**
	 * �P�̃N���X�����擾����T�[�r�X�N���X��
	 */
	ClassInfoProfileService("ClassInfoProfileService"),

	/**
	 * �N���X�����폜����T�[�r�X�N���X��
	 */
	ClassInfoDeleteService("ClassInfoDeleteService");

	/**
	 * �T�[�r�X�N���X��
	 */
	private String serviceName;

	private ServiceNames(String serviceName) {

		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return this.serviceName;
	}
}
