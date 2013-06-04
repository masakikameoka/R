package factory;

import java.io.InputStream;
import java.util.Properties;

import service.Service;

/**
 * サービスインターフェースの実装クラスのインスタンスを作成するクラス
 *
 * @author masaki kameoka
 */
public class ServiceFactory {

	private ServiceFactory() {
	}

	/**
	 * Serviceインターフェースの実装クラスのインスタンスを作成する
	 *
	 * @param key
	 *            プロパティファイルに記述されたキー
	 * @return keyと関連付けられたクラスのインスタンス
	 */
	@SuppressWarnings("rawtypes")
	public static Service getInstance(String key) {

		Service service = null;

		try {
			// クラスパス上のプロパティファイルへのインプットストリームを取得
			InputStream inStream = ServiceFactory.class.getClassLoader()
					.getResourceAsStream("/service.properties");

			Properties prop = new Properties();
			// プロパティをロード
			prop.load(inStream);

			// serviceの完全限定クラス名を取得
			String className = prop.getProperty(key);

			// 取得したクラス名を持つクラスのClassクラスのインスタンスを取得
			Class serviceClass = Class.forName(className);
			// サービスクラスのインスタンスを取得
			service = (Service) serviceClass.newInstance();

		} catch (Exception e) {
			System.err.println("Serviceインスタンスを取得できませんでした。");
		}

		return service;
	}
}
