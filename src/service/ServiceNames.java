package service;

/**
 * サービスクラスの名前のEnumクラス
 *
 * @author masaki kameoka
 *
 */
public enum ServiceNames {

	/**
	 * クラス情報を登録するサービスクラス名
	 */
	ClassInfoCreateService("ClassInfoCreateService"),

	/**
	 * 生徒を登録するサービスクラス名
	 */
	StudentCreateService("StudentCreateService"),

	/**
	 * クラス情報を検索するサービスクラス名
	 */
	ClassInfoSearchService("ClassInfoSearchService"),

	/**
	 * 生徒を検索するサービスクラス名
	 */
	StudentSearchService("StudentSearchService"),

	/**
	 * 生徒を削除するサービスクラス名
	 */
	StudentDeleteService("StudentDeleteService"),

	/**
	 * １人の生徒の詳細を取得するサービスクラス名
	 */
	StudentProfileService("StudentProfileService"),

	/**
	 * 生徒を更新するするサービスクラス名
	 */
	StudentUpdateService("StudentUpdateService"),

	/**
	 * クラス情報を更新するサービスクラス名
	 */
	ClassInfoUpdateServce("ClassInfoUpdateServce"),

	/**
	 * １つのクラス情報を取得するサービスクラス名
	 */
	ClassInfoProfileService("ClassInfoProfileService"),

	/**
	 * クラス情報を削除するサービスクラス名
	 */
	ClassInfoDeleteService("ClassInfoDeleteService");

	/**
	 * サービスクラス名
	 */
	private String serviceName;

	private ServiceNames(String serviceName) {

		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return this.serviceName;
	}
}
