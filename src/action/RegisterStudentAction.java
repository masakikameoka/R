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
 * ���k��V�K�o�^����A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class RegisterStudentAction extends Action {

	/*
	 * (�� Javadoc)
	 *
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// �}������f�[�^���i�[����ϐ�
		Map<String, Object> contents = new HashMap<String, Object>();

		// ���͂��ꂽ�l���i�[����Ă���Form
		StudentForm studentForm = (StudentForm) form;

		// ���k�����i�[����N���X
		Student student = createStudent(studentForm);

		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT,
				student);

		/* �N���X�����i�[ */
		ClassInfo classInfo = new ClassInfo();

		// �N���X��
		classInfo.setClassName(studentForm.getClassName());

		// �w�N
		classInfo.setGrade(studentForm.getGrade());
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		/* �i�����������i�[ */
		PromotionHistory promotionHistory = new PromotionHistory();
		promotionHistory.setFiscalYear(studentForm.getFiscalYear());
		promotionHistory.setDeleteFlg(DeleteFlg.NO_DELETED);
		contents.put(
				ActionToServiceDataTransferMapKeyConstants.PROMOTION_HISTORY,
				promotionHistory);

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentCreateService.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result;

		try {

			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// ����ɓo�^�ł��Ȃ������ꍇ

			// �G���[���b�Z�[�W���i�[
			result = exception.getMessage();

		}

		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);

	}

	public Student createStudent(StudentForm studentForm) {

		Student student = new Student();
		// ��
		student.setFirstName(studentForm.getFirstName());
		// ���J�i
		student.setFirstNameKana(studentForm.getFirstNameKana());
		// ��
		student.setLastName(studentForm.getLastName());
		// ���J�i
		student.setLastNameKana(studentForm.getLastNameKana());
		// ����
		student.setSex(studentForm.getSex());
		// ���l
		student.setRemarks(studentForm.getRemarks());

		// ���N����
		String birthday = studentForm.getBirthdayYear() + "/"
				+ studentForm.getBirthdayMonth() + "/"
				+ studentForm.getBirthdayDay();
		student.setBirthday(birthday);
		student.setDeleteFlg(DeleteFlg.NO_DELETED);

		return student;
	}
}
