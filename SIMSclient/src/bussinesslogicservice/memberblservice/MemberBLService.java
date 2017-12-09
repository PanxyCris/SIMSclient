package bussinesslogicservice.memberblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.member.MemberVO;

public interface MemberBLService {

	/**
	 * 获取用户ID
	 * @return ID
	 */
	public String getID();

	/**
	 * 显示客户信息
	 * @return 客户列表
	 */
	public ArrayList<MemberVO> show();

	/**
	 * 模糊查找用户
	 * @param keyword
	 * @return 所有符合条件的客户列表
	 */
	public ArrayList<MemberVO> fuzzySearch(String keyword,FindMemberType properties);

	/**
	 * 精确查找用户
	 * @param ID
	 * @return 精确客户
	 */
	public MemberVO exactSearch(String ID);

	/**
	 * 增加客户
	 * @return 处理信息
	 */
	public ResultMessage add(MemberVO vo);

	/**
	 * 更新客户
	 * @return 处理信息
	 */
	public ResultMessage update(MemberVO vo);

	/**
	 * 删除客户
	 * @return 处理信息
	 */
	public ResultMessage delete(MemberVO vo);

}
