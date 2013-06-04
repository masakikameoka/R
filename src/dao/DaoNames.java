package dao;

/**
 * Dao�̃N���X��������Enum�N���X
 *
 * @author masaki kameoka
 *
 */
public enum DaoNames {

	/**
	 * �N���X����CRUD�������s���N���X��
	 */
	ClassInfoDao("ClassInfoDao"),
	/**
	 * �i��������CRUD�������s���N���X��
	 */
	PromotionHistoryDao("PromotionHistoryDao"),
	/**
	 * ���k��CRUD�������s���N���X��
	 */
	StudentDao("StudentDao"),
	/**
	 * ���k�X�e�[�^�X��CRUD�������s���N���X��
	 */
	StudentStatusDao("StudentStatusDao");

	/**
	 * �N���X��
	 */
	private String daoName;

	private DaoNames(String daoName) {
		this.daoName = daoName;
	}

	public String getDaoName() {
		return daoName;
	}

}
