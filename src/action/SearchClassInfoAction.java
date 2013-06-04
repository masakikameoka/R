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
import bean.DeleteFlg;
import factory.ServiceFactory;

/**
 * クラス情報を検索するアクション
 *
 * @author masaki kameoka
 *
 */
public class SearchClassInfoAction extends Action {

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

		/* 入力フォームに入力された値を取り出す */
		ClassInfoForm classInfoForm = (ClassInfoForm) form;

		/* クラス情報クラスに入力された値をセット */
		ClassInfo classInfo = new ClassInfo();

		classInfo.setClassName(classInfoForm.getClassName());
		classInfo.setGrade(classInfoForm.getGrade());
		classInfo.setDeleteFlg(DeleteFlg.NO_DELETED);

		// ビジネスロジックを実行するために必要なパラメータを格納する
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoSearchService
						.getServiceName());

		// 結果を格納する変数
		Object result = null;

		// 遷移先のパスを格納する変数
		String mappingPath = null;
		try {
			// 実行し、結果を代入
			result = service.execute(contents);

			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.CLASSINFO_LIST, result);
			mappingPath = MappingPathConstants.SEARCH_CLASSINFO;

		} catch (RuntimeException exception) {
			result = exception.getMessage();
			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.MESSAGE, result);
			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
