package action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
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
 * クラス情報を更新するアクション
 *
 * @author masaki kameoka
 *
 */
public class UpdateClassInfoAction extends Action {

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

		// リクエストパラメーターからクラス情報IDを取得
		int classInfoId = NumberUtils.createInteger(request
				.getParameter(ParameterNameConstants.CLASSINFO_ID));

		/* クラス情報クラスに値をセット */
		ClassInfo classInfo = new ClassInfo();

		classInfo.setClassInfoId(classInfoId);
		classInfo.setClassName(classInfoForm.getClassName());
		classInfo.setGrade(classInfoForm.getGrade());

		// 現在の時間を取得
		Date sysdate = new Date();
		classInfo.setUpdateTime(sysdate);

		// ビジネスロジックを実行するために必要なパラメータを格納する
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoUpdateServce
						.getServiceName());

		// 結果を格納する変数
		Object result;
		try {
			// 実行し、結果を代入
			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// 正常に更新できなかった場合

			// エラーメッセージを格納
			result = exception.getMessage();
		}

		// リクエストスコープに結果をセット
		request.setAttribute(ParameterNameConstants.MESSAGE, result);
		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
