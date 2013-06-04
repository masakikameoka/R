package dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * �f�[�^�ɃA�N�Z�X����N���X
 *
 * @author masaki kameoka
 *
 * @param <T>
 */
@SuppressWarnings("deprecation")
public abstract class Dao<T> {

	/**
	 * �Z�b�V�����t�@�N�g���[
	 */
	private static SessionFactory sessionFactory;

	/* static�C�j�V�����C�U */
	static {

		sessionFactory = new Configuration().configure().buildSessionFactory();

	}
	/**
	 * �Z�b�V����
	 */
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();

	/**
	 * �g�����U�N�V����
	 */
	private static ThreadLocal<Transaction> transaction = new ThreadLocal<Transaction>();

	/**
	 * �N���C�e���A
	 */
	public Criteria criteria;

	/**
	 * �Z�b�V�������擾
	 *
	 * @return session
	 */
	protected static Session getSession() {

		if (session.get() == null) {

			// �Z�b�V�������Ȃ��ꍇ
			connect();
		}

		return session.get();
	}

	/**
	 * �f�[�^�x�[�X�ɐڑ�����
	 */
	public static void connect() {

		if (session.get() == null) {

			session.set(sessionFactory.openSession());
		}
	}

	/**
	 * �Z�b�V���������
	 */
	public static void sessionClose() {

		// �g�����U�N�V�������I�����Ă��Ȃ��ꍇ�́A���[���o�b�N���s��
		rollback();

		Session sess = session.get();
		if (session.get() != null) {

			session.set(null);

			sess.close();
		}
	}

	/**
	 * �g�����U�N�V�����̊J�n
	 */
	public static void beginTransaction() {

		if (transaction.get() == null) {
			transaction.set(session.get().beginTransaction());
		}

	}

	/**
	 * ���[���o�b�N���s��
	 * */
	public static void rollback() {

		// �g�����U�N�V�����I�u�W�F�N�g�̃R�s�[
		Transaction trans = transaction.get();

		if (trans != null) {

			transaction.set(null);
			trans.rollback();
		}
	}

	/**
	 * �R�~�b�g���s��
	 */
	public static void commit() {

		Transaction trans = transaction.get();

		if (trans != null) {

			transaction.set(null);
			trans.commit();

		}
	}

	/**
	 *
	 * ��L�[�Ō���
	 *
	 * @param classtype
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T queryOfId(Class<T> classtype, Object id) {

		Criteria criteria = getSession().createCriteria(classtype);

		// ������ID�Ɠ�����ID�����s�݂̂�I��
		criteria.add(Restrictions.idEq(id));
		return (T) criteria.list().get(0);
	}

	/**
	 * �����̃f�[�^���X�V����
	 *
	 * @param content
	 */
	public void updateContent(T content) {
		getSession().update(content);
	}

	/**
	 *
	 * ��P������Class�N���X�Ƀ}�b�s���O���ꂽ�\���� ��Q�����̒l��ID�Ɏ��s�̃C���X�^���X���擾
	 *
	 * @param classType
	 * @param id
	 * @return T
	 */
	public T load(Class<T> classType, int id) {

		@SuppressWarnings("unchecked")
		T t = (T) getSession().load(classType, id);

		return t;
	}

	/**
	 * �����ɓn�����񖼂̍ő�l���擾
	 *
	 * @param classtype
	 * @param colmnName
	 * @param id
	 * @return
	 */
	public Object getMaxValue(Class<T> classtype, String colmnName, int id) {

		Criteria criteria = getSession().createCriteria(classtype);

		// �������̒l�̗񖼂̍ő�l���ˉe
		Projection projection = Projections.max(colmnName);

		if (id != 0) {
			// ID�w�肪����ꍇ
			criteria.add(Restrictions.idEq(id));
		}
		criteria.setProjection(projection);

		return criteria.list().get(0);
	}

	/**
	 * �����̍s��_���폜����
	 *
	 * @param set
	 */
	public void deleteContent(Set<T> set) {

		for (T content : set) {

			// �_���폜���s��
			this.delete(content);
		}
	}

	/**
	 * �V�K�f�[�^��}������
	 *
	 * @param content
	 */
	public void entryContent(T content) {

		getSession().save(content);

	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {

		return (List<T>) this.criteria.list();

	}

	/**
	 * �P��s��_���폜����
	 *
	 * @param content
	 */
	public abstract void delete(T content);

	/**
	 * ����������ǉ�����
	 *
	 * @param content
	 */
	public abstract void addQuery(T content);

	/**
	 * �֘A�̂���e�[�u���̏������������ɒǉ�����
	 *
	 * @param propertyName
	 * @param queryParamsMap
	 */
	public void addRelationTableQuery(String propertyName,
			Map<String, Object> queryParamsMap) {

		this.criteria = this.criteria.createCriteria(propertyName).add(
				Restrictions.allEq(queryParamsMap));

	}

	/**
	 * Criteria�I�u�W�F�N�g������������
	 *
	 * @param classtype
	 */
	public void initCriteria(Class<T> classtype) {

		this.criteria = getSession().createCriteria(classtype);
	}

}
