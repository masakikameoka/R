package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * �N���X���N���X
 *
 * @author masaki kameoka
 *
 */
public class ClassInfo {

	/**
	 * �N���X���ID
	 */
	private int classInfoId;
	/**
	 * �N���X��
	 */
	private String className;

	/**
	 * �w�N
	 */
	private String grade;
	/**
	 * �X�V����
	 */
	private Date updateTime;

	/**
	 * �o�^����
	 */
	private Date createTime;

	/**
	 * �_���폜�t���O
	 */
	private String deleteFlg = DeleteFlg.NO_DELETED;

	/**
	 * ���Έ�֘A�̂��߂̃Z�b�g
	 */
	private Set<PromotionHistory> history;

	/**
	 * ���k�̐i���������擾
	 *
	 * @return history
	 */
	public Set<PromotionHistory> getHistory() {
		return history;
	}

	/**
	 * ���k�̐i���������Z�b�g
	 *
	 * @param history
	 */
	public void setHistory(Set<PromotionHistory> history) {
		this.history = history;
	}

	/**
	 * �N���X���ID���擾
	 *
	 * @return classInfoId
	 */
	public int getClassInfoId() {
		return classInfoId;
	}

	/**
	 * �N���X���ID���Z�b�g
	 *
	 * @param classInfoId
	 */
	public void setClassInfoId(int classInfoId) {
		this.classInfoId = classInfoId;
	}

	/**
	 * �N���X�����擾
	 *
	 * @return className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * �N���X�����Z�b�g
	 *
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * �w�N���擾
	 *
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * �w�N���Z�b�g
	 *
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * �X�V�������擾
	 *
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * �X�V�������Z�b�g
	 *
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * �o�^�������擾
	 *
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * �X�V�������Z�b�g
	 *
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * �_���폜�t���O���擾
	 *
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * �_���폜�t���O���Z�b�g
	 *
	 * @param deleteFlg
	 *            �Z�b�g���� deleteFlg
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
