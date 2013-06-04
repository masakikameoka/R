package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 進級履歴を表すクラス
 *
 * @author masaki kameoka
 *
 */
public class PromotionHistory implements Serializable {

	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 一対多関連のための生徒クラス
	 */
	private Student student;

	/**
	 * 一対多関連のためのクラス情報クラス
	 */
	private ClassInfo classInfo;
	/**
	 * 年度
	 */
	private String fiscalYear;
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
	 * 進級履歴にある生徒の情報を取得
	 *
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * 進級履歴にある生徒の情報をセット
	 *
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * 進級履歴にあるクラス情報を取得
	 *
	 * @return classinfo
	 */
	public ClassInfo getClassInfo() {
		return classInfo;
	}

	/**
	 * 臨給履歴にあるクラス情報をセット
	 *
	 * @param classType
	 */
	public void setClassInfo(ClassInfo classType) {
		this.classInfo = classType;
	}

	/**
	 * 年度を取得
	 *
	 * @return fiscalYear
	 */
	public String getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * 年度をセット
	 *
	 * @param fiscalYear
	 */
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
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
