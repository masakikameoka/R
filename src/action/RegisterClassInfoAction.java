package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.Service;
import service.ServiceNames;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import action.constant.MappingPathConstants;
import action.constant.ParameterNameConstants;
import action.form.ClassInfoForm;
import bean.ClassInfo;
import factory.ServiceFactory;

/**
 * 新規クラスを作成するアクションクラス
 *
 * @author masaki kameoka
 *
 */
public class RegisterClassInfoAction extends Action {

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

		// 入力された値を格納するForm
		ClassInfoForm classInfoForm = (ClassInfoForm) form;

		// クラス情報を管理
		ClassInfo content = new ClassInfo();

		// 入力されたクラス名をセット
		content.setClassName(classInfoForm.getClassName());

		// 入力された学年をセット
		content.setGrade(classInfoForm.getGrade());

		// ビジネスロジックを実行するために必要なパラメータを格納する
		Map<String, Object> contents = new HashMap<String, Object>();

		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				content);

		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoCreateService
						.getServiceName());

		// 結果を格納する変数
		Object result = null;

		try {

			// 実行し、結果を代入
			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// 正常に登録できなかった場合
			result = exception.getMessage();

		}

		// リクエストスコープに結果をセット
		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
