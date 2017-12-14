package bussiness_stub;

import java.util.ArrayList;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.member.MemberVO;

/**
* ��˵��
*
* @author ****
* @date 2017��10��22��
*/
public class MemberBLService_Stub implements MemberBLService{

	public String getId() {
		return "000001";
	}

	public ArrayList<MemberVO> show() {
		MemberVO member1 = new MemberVO("00001",MemberCategory.SUPPLIER,MemberLevel.LEVEL5,"���","1591515","�Ͼ���ѧ",
				"210064","lq@qq.com","50","20","50","NJU");
		MemberVO member2 = new MemberVO("00002",MemberCategory.RETAILER,MemberLevel.LEVEL4,"NJU","15cs515","�Ͼ���ѧ",
				"210064","lq@qq.com","50","20","50","NJU");
		System.out.println("Show Succeed!\n");
		ArrayList<MemberVO> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		return list;
	}

	public MemberVO exactSearch(String ID) {
		System.out.println("exactSearch Succeed!\n");
		return null;
	}


	@Override
	public ArrayList<MemberVO> find(String keyword, FindMemberType properties) {
		MemberVO member1 = new MemberVO("161250001",MemberCategory.RETAILER,MemberLevel.LEVEL5,"NJU","1591515","�Ͼ���ѧ",
				"210064","lq@qq.com","50","20","50","NJU");
		System.out.println("Show Succeed!\n");
		ArrayList<MemberVO> list = new ArrayList<>();
		list.add(member1);
		return list;
	}

	@Override
	public ResultMessage insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(MemberVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
