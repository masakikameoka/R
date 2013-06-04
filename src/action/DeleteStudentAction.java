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
 * ���k���폜����A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class DeleteStudentAction extends Action {

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

		// �r�W�l�X���W�b�N�����s���邽�߂ɕK�v�ȃp�����[�^���i�[����
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID,
				request.getParameter(ParameterNameConstants.STUDENT_ID));

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentDeleteService.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		try {

			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// ����ɍ폜�ł��Ȃ������ꍇ

			// �G���[���b�Z�[�W���i�[
			result = exception.getMessage();
		}

		// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
		request.setAttribute(ParameterNameConstants.MESSAGE, result);
		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
