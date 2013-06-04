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
import action.form.StudentForm;
import bean.ClassInfo;
import bean.DeleteFlg;
import bean.PromotionHistory;
import bean.Student;
import factory.ServiceFactory;

/**
 * 生徒を新規登録するアクション
 *
 * @author masaki kameoka
 *
 */
public class RegisterStudentAction extends Action {

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

		// 挿入するデータを格納する変数
		Map<String, Object> contents = new HashMap<String, Object>();

		// 入力された値が格納されているForm
		StudentForm studentForm = (StudentForm) form;

		// 生徒情報を格納するクラス
		Student student = createStudent(studentForm);

		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT,
				student);

		/* クラス情報を格納 */
		ClassInfo classInfo = new ClassInfo();

		// クラス名
		classInfo.setClassName(studentForm.getClassName());

		// 学年
		classInfo.setGrade(studentForm.getGrade());
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		/* 進級履歴情報を格納 */
		PromotionHistory promotionHistory = new PromotionHistory();
		promotionHistory.setFiscalYear(studentForm.getFiscalYear());
		promotionHistory.setDeleteFlg(DeleteFlg.NO_DELETED);
		contents.put(
				ActionToServiceDataTransferMapKeyConstants.PROMOTION_HISTORY,
				promotionHistory);

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentCreateService.getServiceName());

		// 結果を格納する変数
		Object result;

		try {

			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// 正常に登録できなかった場合

			// エラーメッセージを格納
			result = exception.getMessage();

		}

		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);

	}

	public Student createStudent(StudentForm studentForm) {

		Student student = new Student();
		// 性
		student.setFirstName(studentForm.getFirstName());
		// 性カナ
		student.setFirstNameKana(studentForm.getFirstNameKana());
		// 名
		student.setLastName(studentForm.getLastName());
		// 名カナ
		student.setLastNameKana(studentForm.getLastNameKana());
		// 性別
		student.setSex(studentForm.getSex());
		// 備考
		student.setRemarks(studentForm.getRemarks());

		// 生年月日
		String birthday = studentForm.getBirthdayYear() + "/"
				+ studentForm.getBirthdayMonth() + "/"
				+ studentForm.getBirthdayDay();
		student.setBirthday(birthday);
		student.setDeleteFlg(DeleteFlg.NO_DELETED);

		return student;
	}
}
