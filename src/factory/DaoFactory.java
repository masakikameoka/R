package factory;

import java.io.InputStream;
import java.util.Properties;

import dao.Dao;

/**
 * ���Dao�N���X�̃C���X�^���X�𐶐�����N���X
 *
 * @author masaki kameoka
 *
 */
public class DaoFactory {

	/**
	 * @param key
	 *            �v���p�e�B�t�@�C���ɋL�q���ꂽ�L�[
	 * @return key�Ɗ֘A�t����ꂽ�N���X�̃C���X�^���X
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Dao<T> getInstance(String key) {

		Dao dao = null;

		try {
			// �N���X�p�X��̃v���p�e�B�t�@�C���ւ̃C���v�b�g�X�g���[�����擾
			InputStream inStream = ServiceFactory.class.getClassLoader()
					.getResourceAsStream("/dao.properties");

			Properties prop = new Properties();

			// �v���p�e�B�����[�h
			prop.load(inStream);

			// Dao�̊��S����N���X�����擾
			String className = prop.getProperty(key);

			// �擾�����N���X�������N���X��Class�N���X�̃C���X�^���X���擾
			Class daoClass = Class.forName(className);

			// ��� Dao�N���X�̃C���X�^���X���擾
			dao = (Dao<T>) daoClass.newInstance();

		} catch (Exception e) {
			System.err.println("Dao�C���X�^���X���擾�ł��܂���ł����B");
		}

		return dao;
	}
}
