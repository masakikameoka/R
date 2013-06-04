package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * クラス情報クラス
 *
 * @author masaki kameoka
 *
 */
public class ClassInfo {

	/**
	 * クラス情報ID
	 */
	private int classInfoId;
	/**
	 * クラス名
	 */
	private String className;

	/**
	 * 学年
	 */
	private String grade;
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
	 * 多対一関連のためのセット
	 */
	private Set<PromotionHistory> history;

	/**
	 * 生徒の進級履歴を取得
	 *
	 * @return history
	 */
	public Set<PromotionHistory> getHistory() {
		return history;
	}

	/**
	 * 生徒の進級履歴をセット
	 *
	 * @param history
	 */
	public void setHistory(Set<PromotionHistory> history) {
		this.history = history;
	}

	/**
	 * クラス情報IDを取得
	 *
	 * @return classInfoId
	 */
	public int getClassInfoId() {
		return classInfoId;
	}

	/**
	 * クラス情報IDをセット
	 *
	 * @param classInfoId
	 */
	public void setClassInfoId(int classInfoId) {
		this.classInfoId = classInfoId;
	}

	/**
	 * クラス名を取得
	 *
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * クラス名をセット
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 学年を取得
	 *
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 学年をセット
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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

	public void addHistory(PromotionHistory promotionHistory) {
		if (this.history == null) {
			history = new HashSet<PromotionHistory>();
		}
		this.history.add(promotionHistory);

	}

}
