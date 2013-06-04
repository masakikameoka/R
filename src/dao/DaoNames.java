package dao;

/**
 * Daoのクラス名を扱うEnumクラス
 *
 * @author masaki kameoka
 *
 */
public enum DaoNames {

	/**
	 * クラス情報のCRUD処理を行うクラス名
	 */
	ClassInfoDao("ClassInfoDao"),
	/**
	 * 進級履歴のCRUD処理を行うクラス名
	 */
	PromotionHistoryDao("PromotionHistoryDao"),
	/**
	 * 生徒のCRUD処理を行うクラス名
	 */
	StudentDao("StudentDao"),
	/**
	 * 生徒ステータスのCRUD処理を行うクラス名
	 */
	StudentStatusDao("StudentStatusDao");

	/**
	 * クラス名
	 */
	private String daoName;

	private DaoNames(String daoName) {
		this.daoName = daoName;
	}

	public String getDaoName() {
		return daoName;
	}

}
