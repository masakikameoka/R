package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.constant.ActionToServiceDataTransferMapKeyConstants;
import action.constant.MappingPathConstants;
import action.constant.ParameterNameConstants;

import service.Service;
import service.ServiceNames;
import factory.ServiceFactory;

/**
 * クラス情報削除画面を生成するアクション
 *
 * @author masaki kameoka
 *
 */
public class CreateClassInfoDeletePageAction extends Action {

	/*
	 *
	 * (非 Javadoc)
	 *
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// ビジネスロジックを実行するために必要なパラメータを格納する
		Map<String, Object> contents = new HashMap<String, Object>();

		// クラス情報ID（クラス情報表の主キー）を追加
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID,
				request.getParameter(ParameterNameConstants.CLASSINFO_ID));

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoProfileService
						.getServiceName());

		// 結果を格納する変数
		Object result = null;

		// 遷移先のパスを格納する変数
		String mappingPath = null;

		try {
			// 実行し、結果を代入
			result = service.execute(contents);

			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.CLASSINFO, result);

			// 遷移先のパスを設定
			mappingPath = MappingPathConstants.PROFILE_CLASSINFO;

		} catch (RuntimeException exception) {

			// 正常に取得できなかった場合

			// エラーメッセージを格納
			result = exception.getMessage();

			request.setAttribute(ParameterNameConstants.MESSAGE, result);

			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
