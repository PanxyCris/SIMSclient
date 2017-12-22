package bussinesslogic.accountbookbl;

import java.util.ArrayList;

import bussinesslogic.accountbl.AccountTransition;
import bussinesslogic.commoditybl.CommodityTransiton;
import bussinesslogic.memberbl.MemberTransition;
import po.AccountBookPO;
import po.AccountPO;
import po.MemberPO;
import po.commodity.CommodityPO;
import vo.accountbookvo.AccountBookVO;
import vo.accountvo.AccountVO;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;

public class AccountBookTransition {
	
	AccountTransition accountTransition;
	MemberTransition memberTransition;
	CommodityTransiton commodityTransiton;
	
	public AccountBookPO VOtoPO(AccountBookVO accountBookVO) {
		AccountBookPO accountBookPO = null;
		ArrayList<CommodityPO> commodityPOs=new ArrayList<>();
		ArrayList<CommodityVO> commodityVOs=accountBookVO.getCommodityVOs();
		{
			for (int i = 0; i < commodityVOs.size(); i++) {
				commodityPOs.add(commodityTransiton.VOtoPO(commodityVOs.get(i)));
			}
		}
		ArrayList<MemberPO> memberPOs=new ArrayList<>();
		ArrayList<MemberVO> memberVOs=accountBookVO.getMemeberVOs();
		{
			for (int i = 0; i < memberVOs.size(); i++) {
				memberPOs.add(memberTransition.VOtoPO(memberVOs.get(i)));
			}
		}
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		ArrayList<AccountVO> accountVOs=accountBookVO.getAccountVOs();
		{
			for (int i = 0; i < accountVOs.size(); i++) {
				accountPOs.add(accountTransition.VOtoPO(accountVOs.get(i)));
			}
		}
		String id=accountBookVO.getId();
		String date=accountBookVO.getDate();
		String clerkId=accountBookVO.getClerkID();
		accountBookPO=new AccountBookPO(id, date, clerkId, commodityPOs, memberPOs, accountPOs);
		return accountBookPO;
	}

	public AccountBookVO POtoVO(AccountBookPO accountBookPO) {
		
		AccountBookVO accountBookVO = null;
		ArrayList<CommodityVO> commodityVOs=new ArrayList<>();
		ArrayList<CommodityPO> commodityPOs=accountBookPO.getCommodityPOs();
		{
			for (int i = 0; i < commodityPOs.size(); i++) {
				commodityVOs.add(commodityTransiton.POtoVO(commodityPOs.get(i)));
			}
		}
		ArrayList<MemberVO> memberVOs=new ArrayList<>();
		ArrayList<MemberPO> memberPOs=accountBookPO.getMemberPOs();
		{
			for (int i = 0; i < memberPOs.size(); i++) {
				memberVOs.add(memberTransition.POtoVO(memberPOs.get(i)));
			}
		}
		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		ArrayList<AccountPO> accountPOs=accountBookPO.getAccountPOs();
		{
			for (int i = 0; i < accountPOs.size(); i++) {
				accountVOs.add(accountTransition.POtoVO(accountPOs.get(i)));
			}
		}
		String id=accountBookPO.getID();
		String date=accountBookPO.getDate();
		String cleckId=accountBookPO.getClerkID();
		accountBookVO=new AccountBookVO(id, date, cleckId, commodityVOs, memberVOs, accountVOs);
		return accountBookVO;
	}
}
