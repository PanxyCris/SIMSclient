package SIMSclient.src.bussinesslogicservice.memberblservice;

import java.util.ArrayList;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.vo.member.MemberVO;

public interface MemberBLService {

	/**
	 * ��ȡ�û�ID
	 * @return ID
	 */
	public String getID();

	/**
	 * ��ʾ�ͻ���Ϣ
	 * @return �ͻ��б�
	 */
	public ArrayList<MemberVO> show();

	/**
	 * ģ�������û�
	 * @param keyword
	 * @return ���з��������Ŀͻ��б�
	 */
	public ArrayList<MemberVO> fuzzySearch(String keyword);

	/**
	 * ��ȷ�����û�
	 * @param ID
	 * @return ��ȷ�ͻ�
	 */
	public MemberVO exactSearch(String ID);

	/**
	 * ���ӿͻ�
	 * @return ������Ϣ
	 */
	public ResultMessage add();

	/**
	 * ���¿ͻ�
	 * @return ������Ϣ
	 */
	public ResultMessage update();

	/**
	 * ɾ���ͻ�
	 * @return ������Ϣ
	 */
	public ResultMessage delete();

}
