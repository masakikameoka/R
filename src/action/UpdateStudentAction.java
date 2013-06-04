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
import action.form.StudentForm;
import bean.Student;
import factory.ServiceFactory;

/**
 *
 * 生徒の更新を行うクラス
 *
 * @author masaki kameoka 　
 */
public class UpdateStudentAction extends Action {

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

		// 入力された値が格納されているForm
		StudentForm studentForm = (StudentForm) form;

		// 生徒更新に必要な情報をマップで格納
		Map<String, Object> contents = new HashMap<String, Object>();

		/* 入力された値を生徒オブジェクトにセット */
		Student student = new Student();
		int studentId = NumberUtils.createInteger(request
				.getParameter(ParameterNameConstants.STUDENT_ID));

		student.setStudentId(studentId);
		student.setFirstName(studentForm.getFirstName());
		student.setFirstNameKana(studentForm.getFirstNameKana());
		student.setLastName(studentForm.getLastName());
		student.setLastNameKana(studentForm.getLastNameKana());
		student.setRemarks(studentForm.getRemarks());

		// 現在の時間を取得
		Date sysdate = new Date();

		student.setUpdateTime(sysdate);
		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT,
				student);

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentUpdateService.getServiceName());

		// 結果を格納する変数
		Object result = null;

		try {
			// 結果を格納
			result = service.execute(contents);
		} catch (Exception exception) {

			// 正常に更新できなかった場合

			// エラーメッセージを格納
			result = exception.getMessage();
		}
		// リクエストスコープに結果を格納
		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
