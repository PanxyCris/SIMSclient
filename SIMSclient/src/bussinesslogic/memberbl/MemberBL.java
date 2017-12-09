package bussinesslogic.memberbl;

import java.util.ArrayList;


import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindMemberType;
import vo.member.MemberVO;

public class MemberBL implements MemberBLService {

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> show() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MemberVO exactSearch(String ID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<MemberVO> fuzzySearch(String keyword, FindMemberType properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
