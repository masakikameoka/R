package factory;

import java.io.InputStream;
import java.util.Properties;

import dao.Dao;

/**
 * 具象Daoクラスのインスタンスを生成するクラス
 *
 * @author masaki kameoka
 *
 */
public class DaoFactory {

	/**
	 * @param key
	 *            プロパティファイルに記述されたキー
	 * @return keyと関連付けられたクラスのインスタンス
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Dao<T> getInstance(String key) {

		Dao dao = null;

		try {
			// クラスパス上のプロパティファイルへのインプットストリームを取得
			InputStream inStream = ServiceFactory.class.getClassLoader()
					.getResourceAsStream("/dao.properties");

			Properties prop = new Properties();

			// プロパティをロード
			prop.load(inStream);

			// Daoの完全限定クラス名を取得
			String className = prop.getProperty(key);

			// 取得したクラス名を持つクラスのClassクラスのインスタンスを取得
			Class daoClass = Class.forName(className);

			// 具象 Daoクラスのインスタンスを取得
			dao = (Dao<T>) daoClass.newInstance();

		} catch (Exception e) {
			System.err.println("Daoインスタンスを取得できませんでした。");
		}

		return dao;
	}
}
