package dao;

import org.hibernate.criterion.Example;

import bean.DeleteFlg;
import bean.PromotionHistory;
import convert.Convertor;

/**
 * 進級履歴クラスのCLUDを行うクラス
 *
 * @author masaki kameoka
 *
 */
public class PromotionHistoryDao extends Dao<PromotionHistory> {

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(PromotionHistory promotionHistory) {

		// 削除フラグを立てる
		promotionHistory.setDeleteFlg(DeleteFlg.DELETED);

		// 更新する
		this.updateContent(promotionHistory);

	}

	/*
	 * (非 Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	@Override
	public void addQuery(PromotionHistory promotionHistory) {

		// 空文字列をNULLに変換
		Convertor.convertBlankStringToNull(promotionHistory);

		// 検索条件を設定
		criteria.add(Example.create(promotionHistory));

	}

}
