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
 * �N���X���폜��ʂ𐶐�����A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class CreateClassInfoDeletePageAction extends Action {

	/*
	 *
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

		// �N���X���ID�i�N���X���\�̎�L�[�j��ǉ�
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO_ID,
				request.getParameter(ParameterNameConstants.CLASSINFO_ID));

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoProfileService
						.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		// �J�ڐ�̃p�X���i�[����ϐ�
		String mappingPath = null;

		try {
			// ���s���A���ʂ���
			result = service.execute(contents);

			// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
			request.setAttribute(ParameterNameConstants.CLASSINFO, result);

			// �J�ڐ�̃p�X��ݒ�
			mappingPath = MappingPathConstants.PROFILE_CLASSINFO;

		} catch (RuntimeException exception) {

			// ����Ɏ擾�ł��Ȃ������ꍇ

			// �G���[���b�Z�[�W���i�[
			result = exception.getMessage();

			request.setAttribute(ParameterNameConstants.MESSAGE, result);

			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
