package bussinesslogicservice.memberblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.member.MemberVO;

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
	public ArrayList<MemberVO> fuzzySearch(String keyword,FindMemberType properties);

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
	public ResultMessage add(MemberVO vo);

	/**
	 * ���¿ͻ�
	 * @return ������Ϣ
	 */
	public ResultMessage update(MemberVO vo);

	/**
	 * ɾ���ͻ�
	 * @return ������Ϣ
	 */
	public ResultMessage delete(MemberVO vo);

}
