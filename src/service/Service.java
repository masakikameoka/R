package service;

import java.util.Map;

/**
 * �@�\�̃��W�b�N���Ăяo���C���^�[�t�F�[�X���`
 *
 * @author masaki
 *
 */
public interface Service {
	/**
	 * �r�W�l�X���W�b�N�����s����
	 *
	 * @param contents
	 *            �r�W�l�X���W�b�N�̎��s�ɕK�v�ȃf�[�^
	 */
	public Object execute(Map<String, Object> contents);
}
