package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import service.Service;
import service.ServiceNames;
import action.constant.ActionToServiceDataTransferMapKeyConstants;
import action.constant.MappingPathConstants;
import action.constant.ParameterNameConstants;
import action.form.SearchForm;
import bean.ClassInfo;
import bean.DeleteFlg;
import bean.Student;
import bean.StudentStatus;
import factory.ServiceFactory;

/**
 * 生徒の情報を検索する
 *
 * @author masaki kameoka
 *
 */
public class SearchStudentAction extends Action {

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
		SearchForm searchForm = (SearchForm) form;
		String className = searchForm.getClassName();
		String grade = searchForm.getGrade();

		/* クラス情報クラスをインスタンス化し、取り出した値を代入 */
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassName(className);
		classInfo.setGrade(grade);
		classInfo.setDeleteFlg(DeleteFlg.NO_DELETED);

		/* 生徒クラスをインスタンス化し入力された値を代入 */
		Student student = new Student();
		student.setFirstName(searchForm.getFirstName());
		student.setLastName(searchForm.getLastName());
		student.setFirstNameKana(searchForm.getFirstNameKana());
		student.setLastNameKana(searchForm.getLastNameKana());
		student.setDeleteFlg(DeleteFlg.NO_DELETED);
		String sex = searchForm.getSex();

		if (StringUtils.isNotBlank(sex)) {
			// 性別で検索する場合
			student.setSex(sex);
		}

		StudentStatus studentStatus = new StudentStatus();
		studentStatus.setClassTypeValue(classInfo);
		studentStatus.setStudentValue(student);

		// ビジネスロジックを実行するために必要なパラメータを格納する
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT_STATUS,
				studentStatus);
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// ビジネスロジックを行うクラスをインスタンス化
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentSearchService.getServiceName());

		// 結果を格納する変数
		Object result = null;

		// 遷移先のパスを格納する変数
		String mappingPath = null;
		try {
			// 実行し、結果を代入
			result = service.execute(contents);
			mappingPath = MappingPathConstants.SEARCH_STUDENT;

			// リクエストスコープに結果をセット
			request.setAttribute(ParameterNameConstants.STUDENT_STATUS_LIST,
					result);

		} catch (RuntimeException exception) {

			// エラーメッセージを取得
			result = exception.getMessage();

			request.setAttribute(ParameterNameConstants.MESSAGE, result);
			mappingPath = MappingPathConstants.RESULT;

		}
		return mapping.findForward(mappingPath);
	}
}
