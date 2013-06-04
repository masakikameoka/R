package service;

import java.util.Map;

/**
 * 機能のロジックを呼び出すインターフェースを定義
 *
 * @author masaki
 *
 */
public interface Service {
	/**
	 * ビジネスロジックを実行する
	 *
	 * @param contents
	 *            ビジネスロジックの実行に必要なデータ
	 */
	public Object execute(Map<String, Object> contents);
}
