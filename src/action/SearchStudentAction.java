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
 * ���k�̏�����������
 *
 * @author masaki kameoka
 *
 */
public class SearchStudentAction extends Action {

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

		/* ���̓t�H�[���ɓ��͂��ꂽ�l�����o�� */
		SearchForm searchForm = (SearchForm) form;
		String className = searchForm.getClassName();
		String grade = searchForm.getGrade();

		/* �N���X���N���X���C���X�^���X�����A���o�����l���� */
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassName(className);
		classInfo.setGrade(grade);
		classInfo.setDeleteFlg(DeleteFlg.NO_DELETED);

		/* ���k�N���X���C���X�^���X�������͂��ꂽ�l���� */
		Student student = new Student();
		student.setFirstName(searchForm.getFirstName());
		student.setLastName(searchForm.getLastName());
		student.setFirstNameKana(searchForm.getFirstNameKana());
		student.setLastNameKana(searchForm.getLastNameKana());
		student.setDeleteFlg(DeleteFlg.NO_DELETED);
		String sex = searchForm.getSex();

		if (StringUtils.isNotBlank(sex)) {
			// ���ʂŌ�������ꍇ
			student.setSex(sex);
		}

		StudentStatus studentStatus = new StudentStatus();
		studentStatus.setClassTypeValue(classInfo);
		studentStatus.setStudentValue(student);

		// �r�W�l�X���W�b�N�����s���邽�߂ɕK�v�ȃp�����[�^���i�[����
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT_STATUS,
				studentStatus);
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentSearchService.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		// �J�ڐ�̃p�X���i�[����ϐ�
		String mappingPath = null;
		try {
			// ���s���A���ʂ���
			result = service.execute(contents);
			mappingPath = MappingPathConstants.SEARCH_STUDENT;

			// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
			request.setAttribute(ParameterNameConstants.STUDENT_STATUS_LIST,
					result);

		} catch (RuntimeException exception) {

			// �G���[���b�Z�[�W���擾
			result = exception.getMessage();

			request.setAttribute(ParameterNameConstants.MESSAGE, result);
			mappingPath = MappingPathConstants.RESULT;

		}
		return mapping.findForward(mappingPath);
	}
}
