package dao;

import org.hibernate.criterion.Example;

import bean.DeleteFlg;
import bean.PromotionHistory;
import convert.Convertor;

/**
 * �i�������N���X��CLUD���s���N���X
 *
 * @author masaki kameoka
 *
 */
public class PromotionHistoryDao extends Dao<PromotionHistory> {

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(PromotionHistory promotionHistory) {

		// �폜�t���O�𗧂Ă�
		promotionHistory.setDeleteFlg(DeleteFlg.DELETED);

		// �X�V����
		this.updateContent(promotionHistory);

	}

	/*
	 * (�� Javadoc)
	 *
	 * @see dao.Dao#queryContent(java.lang.Object)
	 */
	@Override
	public void addQuery(PromotionHistory promotionHistory) {

		// �󕶎����NULL�ɕϊ�
		Convertor.convertBlankStringToNull(promotionHistory);

		// ����������ݒ�
		criteria.add(Example.create(promotionHistory));

	}

}
