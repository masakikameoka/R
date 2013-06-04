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
 * ���k�̃v���t�B�[�����擾����A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class GetStudentProfileAction extends Action {

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
		Map<String, Object> content = new HashMap<String, Object>();
		content.put(ActionToServiceDataTransferMapKeyConstants.STUDENT_ID,
				request.getParameter(ParameterNameConstants.STUDENT_ID));

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.StudentProfileService
						.getServiceName());

		// �J�ڐ�ւ̃p�X�Ƀ}�b�s���O����Ă��閼�O���i�[����ϐ�
		String mappingPath = null;

		// ���ʂ��i�[����ϐ�
		Object result = null;

		try {
			// ���s���A���ʂ���
			result = service.execute(content);

			// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
			request.setAttribute(ParameterNameConstants.STUDENT_STATUS, result);
			mappingPath = MappingPathConstants.STUDENT_PROFILE;
		} catch (RuntimeException exception) {

			// ����Ɏ擾�ł��Ȃ������ꍇ

			// ���ʂ��i�[����ϐ�
			result = exception.getMessage();

			// ���ʂ����N�G�X�g�X�R�[�v�֊i�[
			request.setAttribute(ParameterNameConstants.MESSAGE, result);

			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
