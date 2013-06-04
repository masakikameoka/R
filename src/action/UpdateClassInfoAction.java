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
import action.form.ClassInfoForm;
import bean.ClassInfo;
import factory.ServiceFactory;

/**
 * �N���X�����X�V����A�N�V����
 *
 * @author masaki kameoka
 *
 */
public class UpdateClassInfoAction extends Action {

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

		// ���N�G�X�g�p�����[�^�[����N���X���ID���擾
		int classInfoId = NumberUtils.createInteger(request
				.getParameter(ParameterNameConstants.CLASSINFO_ID));

		/* �N���X���N���X�ɒl���Z�b�g */
		ClassInfo classInfo = new ClassInfo();

		classInfo.setClassInfoId(classInfoId);
		classInfo.setClassName(classInfoForm.getClassName());
		classInfo.setGrade(classInfoForm.getGrade());

		// ���݂̎��Ԃ��擾
		Date sysdate = new Date();
		classInfo.setUpdateTime(sysdate);

		// �r�W�l�X���W�b�N�����s���邽�߂ɕK�v�ȃp�����[�^���i�[����
		Map<String, Object> contents = new HashMap<String, Object>();
		contents.put(ActionToServiceDataTransferMapKeyConstants.CLASSINFO,
				classInfo);

		// �r�W�l�X���W�b�N���s���N���X���C���X�^���X��
		Service service = ServiceFactory
				.getInstance(ServiceNames.ClassInfoUpdateServce
						.getServiceName());

		// ���ʂ��i�[����ϐ�
		Object result;
		try {
			// ���s���A���ʂ���
			result = service.execute(contents);

		} catch (RuntimeException exception) {

			// ����ɍX�V�ł��Ȃ������ꍇ

			// �G���[���b�Z�[�W���i�[
			result = exception.getMessage();
		}

		// ���N�G�X�g�X�R�[�v�Ɍ��ʂ��Z�b�g
		request.setAttribute(ParameterNameConstants.MESSAGE, result);
		return mapping.findForward(MappingPathConstants.RESULT);
	}
}
