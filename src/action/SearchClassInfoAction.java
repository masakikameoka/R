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
import bean.DeleteFlg;
import factory.ServiceFactory;

/**
 * �N���X������������A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class SearchClassInfoAction extends Action {

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
		ClassInfoForm classInfoForm = (ClassInfoForm) form;

		/* �N���X���N���X�ɓ��͂��ꂽ�l���Z�b�g */
		ClassInfo classInfo = new ClassInfo();

		classInfo.setClassName(classInfoForm.getClassName());
		classInfo.setGrade(classInfoForm.getGrade());
		classInfo.setDeleteFlg(DeleteFlg.NO_DELETED);

		// �r�W�l�X���W�b�N�����s���邽�߂ɕK�v�ȃp�����[�^���i�[����
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoSearchService
						.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result = null;

		// �J�ڐ�̃p�X���i�[����ϐ�
		String mappingPath = null;
		try {
			// ���s���A���ʂ���
			result = service.execute(contents);

			// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
			request.setAttribute(ParameterNameConstants.CLASSINFO_LIST, result);
			mappingPath = MappingPathConstants.SEARCH_CLASSINFO;

		} catch (RuntimeException exception) {
			result = exception.getMessage();
			// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
			request.setAttribute(ParameterNameConstants.MESSAGE, result);
			mappingPath = MappingPathConstants.RESULT;
		}

		return mapping.findForward(mappingPath);
	}
}
