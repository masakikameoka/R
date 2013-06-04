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
 * ���k�̍X�V���s���N���X
 *
 * @author masaki kameoka �@
 */
public class UpdateStudentAction extends Action {

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

		// ���͂��ꂽ�l���i�[����Ă���Form
		StudentForm studentForm = (StudentForm) form;

		// ���k�X�V�ɕK�v�ȏ����}�b�v�Ŋi�[
		Map<String, Object> contents = new HashMap<String, Object>();

		/* ���͂��ꂽ�l�𐶓k�I�u�W�F�N�g�ɃZ�b�g */
		Student student = new Student();
		int studentId = NumberUtils.createInteger(request
				.getParameter(ParameterNameConstants.STUDENT_ID));

		student.setStudentId(studentId);
		student.setFirstName(studentForm.getFirstName());
		student.setFirstNameKana(studentForm.getFirstNameKana());
		student.setLastName(studentForm.getLastName());
		student.setLastNameKana(studentForm.getLastNameKana());
		student.setRemarks(studentForm.getRemarks());

		// ���݂̎��Ԃ��擾
		Date sysdate = new Date();

		student.setUpdateTime(sysdate);
		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT,
				student);

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentUpdateService.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		try {
			// ���ʂ��i�[
			result = service.execute(contents);
		} catch (Exception exception) {

			// ����ɍX�V�ł��Ȃ������ꍇ

			// �G���[���b�Z�[�W���i�[
			result = exception.getMessage();
		}
		// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��i�[
		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
