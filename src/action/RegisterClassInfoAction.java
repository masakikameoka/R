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
import action.form.ClassInfoForm;
import bean.ClassInfo;
import factory.ServiceFactory;

/**
 * �V�K�N���X���쐬����A�N�V�����N���X
 *
 * @author masaki kameoka
 *
 */
public class RegisterClassInfoAction extends Action {

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

		// ���͂��ꂽ�l���i�[����Form
		ClassInfoForm classInfoForm = (ClassInfoForm) form;

		// �N���X�����Ǘ�
		ClassInfo content = new ClassInfo();

		// ���͂��ꂽ�N���X�����Z�b�g
		content.setClassName(classInfoForm.getClassName());

		// ���͂��ꂽ�w�N���Z�b�g
		content.setGrade(classInfoForm.getGrade());

		// �r�W�l�X���W�b�N�����s���邽�߂ɕK�v�ȃp�����[�^���i�[����
		Map<String, Object> contents = new HashMap<String, Object>();

		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				content);

		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoCreateService
						.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		try {

			// ���s���A���ʂ���
			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// ����ɓo�^�ł��Ȃ������ꍇ
			result = exception.getMessage();

		}

		// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
		request.setAttribute(ParameterNameConstants.MESSAGE, result);

		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
