package factory;

import java.io.InputStream;
import java.util.Properties;

import service.Service;

/**
 * �T�[�r�X�C���^�[�t�F�[�X�̎����N���X�̃C���X�^���X���쐬����N���X
 *
 * @author masaki kameoka
 */
public class ServiceFactory {

	private ServiceFactory() {
	}

	/**
	 * Service�C���^�[�t�F�[�X�̎����N���X�̃C���X�^���X���쐬����
	 *
	 * @param key
	 *            �v���p�e�B�t�@�C���ɋL�q���ꂽ�L�[
	 * @return key�Ɗ֘A�t����ꂽ�N���X�̃C���X�^���X
	 */
	@SuppressWarnings("rawtypes")
	public static Service getInstance(String key) {

		Service service = null;

		try {
			// �N���X�p�X��̃v���p�e�B�t�@�C���ւ̃C���v�b�g�X�g���[�����擾
			InputStream inStream = ServiceFactory.class.getClassLoader()
					.getResourceAsStream("/service.properties");

			Properties prop = new Properties();
			// �v���p�e�B�����[�h
			prop.load(inStream);

			// service�̊��S����N���X�����擾
			String className = prop.getProperty(key);

			// �擾�����N���X�������N���X��Class�N���X�̃C���X�^���X���擾
			Class serviceClass = Class.forName(className);
			// �T�[�r�X�N���X�̃C���X�^���X���擾
			service = (Service) serviceClass.newInstance();

		} catch (Exception e) {
			System.err.println("Service�C���X�^���X���擾�ł��܂���ł����B");
		}

		return service;
	}
}
