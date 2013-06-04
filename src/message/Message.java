package message;

/**
 * 処理結果のメッセージ定数クラス
 *
 * @author masaki kameoka
 *
 */
public class Message {

	private Message() {
	}

	/**
	 * 登録処理が成功したときのメッセージ
	 */
	public static final String CREATE_SUCSESS_MESSAGE = "登録が完了しました。";

	/**
	 * 登録に失敗したときのメッセージ
	 */
	public static final String CREATE_FAILD_MESSAGE = "登録に失敗しました。";

	/**
	 * 更新が成功したときのメッセージ
	 */
	public static final String UPDATE_SUCESS_MESSAGE = "更新が完了しました。";

	/**
	 * 更新が失敗したときのメッセージ
	 */
	public static final String UPDATE_FAILD_MESSAGE = "更新が失敗しました。";

	/**
	 * 削除か成功したときのメッセージ
	 */
	public static final String DELETE_SUCESS_MESSAGE = "削除が完了しました。";
	/**
	 * 削除が失敗したときのメッセージ
	 */
	public static final String DELETEA_FAILD_MESSAGE = "削除が失敗しました。";

	/**
	 * 読み込みが失敗したときのメッセージ
	 */
	public static final String READ_FAILD_MESSAGE = "読み込みに失敗しました。";
}
