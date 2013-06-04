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
 * データにアクセスするクラス
 *
 * @author masaki kameoka
 *
 * @param <T>
 */
@SuppressWarnings("deprecation")
public abstract class Dao<T> {

	/**
	 * セッションファクトリー
	 */
	private static SessionFactory sessionFactory;

	/* staticイニシャライザ */
	static {

		sessionFactory = new Configuration().configure().buildSessionFactory();

	}
	/**
	 * セッション
	 */
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();

	/**
	 * トランザクション
	 */
	private static ThreadLocal<Transaction> transaction = new ThreadLocal<Transaction>();

	/**
	 * クライテリア
	 */
	public Criteria criteria;

	/**
	 * セッションを取得
	 *
	 * @return session
	 */
	protected static Session getSession() {

		if (session.get() == null) {

			// セッションがない場合
			connect();
		}

		return session.get();
	}

	/**
	 * データベースに接続する
	 */
	public static void connect() {

		if (session.get() == null) {

			session.set(sessionFactory.openSession());
		}
	}

	/**
	 * セッションを閉じる
	 */
	public static void sessionClose() {

		// トランザクションが終了していない場合は、ロールバックを行う
		rollback();

		Session sess = session.get();
		if (session.get() != null) {

			session.set(null);

			sess.close();
		}
	}

	/**
	 * トランザクションの開始
	 */
	public static void beginTransaction() {

		if (transaction.get() == null) {
			transaction.set(session.get().beginTransaction());
		}

	}

	/**
	 * ロールバックを行う
	 * */
	public static void rollback() {

		// トランザクションオブジェクトのコピー
		Transaction trans = transaction.get();

		if (trans != null) {

			transaction.set(null);
			trans.rollback();
		}
	}

	/**
	 * コミットを行う
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
	 * 主キーで検索
	 *
	 * @param classtype
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T queryOfId(Class<T> classtype, Object id) {

		Criteria criteria = getSession().createCriteria(classtype);

		// 引数のIDと等しいIDを持つ行のみを選択
		criteria.add(Restrictions.idEq(id));
		return (T) criteria.list().get(0);
	}

	/**
	 * 既存のデータを更新する
	 *
	 * @param content
	 */
	public void updateContent(T content) {
		getSession().update(content);
	}

	/**
	 *
	 * 第１引数のClassクラスにマッピングされた表から 第２引数の値をIDに持つ行のインスタンスを取得
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
	 * 引数に渡した列名の最大値を取得
	 *
	 * @param classtype
	 * @param colmnName
	 * @param id
	 * @return
	 */
	public Object getMaxValue(Class<T> classtype, String colmnName, int id) {

		Criteria criteria = getSession().createCriteria(classtype);

		// 第二引数の値の列名の最大値を射影
		Projection projection = Projections.max(colmnName);

		if (id != 0) {
			// ID指定がある場合
			criteria.add(Restrictions.idEq(id));
		}
		criteria.setProjection(projection);

		return criteria.list().get(0);
	}

	/**
	 * 複数の行を論理削除する
	 *
	 * @param set
	 */
	public void deleteContent(Set<T> set) {

		for (T content : set) {

			// 論理削除を行う
			this.delete(content);
		}
	}

	/**
	 * 新規データを挿入する
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
	 * 単一行を論理削除する
	 *
	 * @param content
	 */
	public abstract void delete(T content);

	/**
	 * 検索条件を追加する
	 *
	 * @param content
	 */
	public abstract void addQuery(T content);

	/**
	 * 関連のあるテーブルの情報を検索条件に追加する
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
	 * Criteriaオブジェクトを初期化する
	 *
	 * @param classtype
	 */
	public void initCriteria(Class<T> classtype) {

		this.criteria = getSession().createCriteria(classtype);
	}

}
