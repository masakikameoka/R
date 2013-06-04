package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 生徒クラス
 *
 * @author masaki kameoka
 *
 */
public class Student {

	/**
	 * 生徒ID
	 */
	private int studentId;

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
	 * 生年月日を取得
	 */
	private String birthday;

	/**
	 * 性別
	 */
	private String sex;

	/**
	 * 備考
	 */
	private String remarks;

	/**
	 * 更新日時
	 */
	private Date updateTime;

	/**
	 * 登録日時
	 */
	private Date createTime;

	/**
	 * 論理削除フラグ
	 */
	private String deleteFlg = DeleteFlg.NO_DELETED;

	/**
	 * 多対一関連のための進級履歴セット
	 */
	private Set<PromotionHistory> history;

	/**
	 * 進級履歴を追加する
	 *
	 * @param history
	 */
	public void addHistory(PromotionHistory history) {

		if (this.history == null) {

			// 履歴セットがnullな場合
			this.history = new HashSet<PromotionHistory>();
		}

		this.history.add(history);

	}

	/**
	 * クラスの進級履歴を取得
	 *
	 * @return history
	 */
	public Set<PromotionHistory> getHistory() {
		return history;
	}

	/**
	 * クラスの進級履歴をセット
	 *
	 * @param history
	 */
	public void setHistory(Set<PromotionHistory> history) {
		this.history = history;
	}

	/**
	 * 生徒IDを取得
	 *
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * 生徒IDをセット
	 *
	 * @param studentid
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

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
	 * 生年月日を取得
	 *
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 *
	 * 生年月日をセット
	 *
	 * @param birthday
	 *
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	 *
	 */
	public void setSex(String sex) {

		this.sex = sex;
	}

	/**
	 * 備考を取得
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 更新日時を取得
	 *
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新日時をセット
	 *
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 登録日時を取得
	 *
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 更新日時をセット
	 *
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 論理削除フラグを取得
	 *
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * 論理削除フラグをセット
	 *
	 * @param deleteFlg
	 *            セットする deleteFlg
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
