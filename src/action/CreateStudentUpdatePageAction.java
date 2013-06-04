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
 * 生徒情報を更新するページを生成するアクション
 *
 * @author masaki kameoka
 *
 */
public class CreateStudentUpdatePageAction extends Action {

	/*
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
		Map<String, Object> content = new HashMap<String, Object>();
		content.put(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID,
				request.getParameter(ParameterNameConstants.STUDENT_ID));

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentProfileService
						.getServiceName());

		// 結果を格納する変数
		Object result = null;

		// 遷移先のパスを格納する変数
		String mappingPath = null;

		try {
			// 実行し、結果を代入
			result = service.execute(content);

			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.STUDENT_STATUS, result);

			mappingPath = MappingPathConstants.UPDATE_STUDENT;

		} catch (RuntimeException exception) {

			// 正常に取得できなかった場合

			// エラーメッセージを格納
			result = exception.getMessage();

			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.MESSAGE, result);

			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
