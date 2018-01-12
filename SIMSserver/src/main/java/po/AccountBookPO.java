package po;

import java.util.ArrayList;

import po.commodity.CommodityPO;

public class AccountBookPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String date;
	private String clerkID;//����ԱID
	private ArrayList<CommodityPO> commodityPOs;//��Ʒ�б�
	private ArrayList<MemberPO> memberPOs;//�ͻ��б�
	private ArrayList<AccountPO> accountPOs;//�˻��б�

	public AccountBookPO(String date, String clerkID,ArrayList<CommodityPO> commodityPOs,ArrayList<MemberPO> memberPOs
			,ArrayList<AccountPO> accountPOs) {
		this.date=date;
		this.clerkID=clerkID;
		this.commodityPOs=commodityPOs;
		this.memberPOs=memberPOs;
		this.accountPOs=accountPOs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public ArrayList<CommodityPO> getCommodityPOs() {
		return commodityPOs;
	}

	public void setCommodityPOs(ArrayList<CommodityPO> commodityPOs) {
		this.commodityPOs = commodityPOs;
	}

	public ArrayList<MemberPO> getMemberPOs() {
		return memberPOs;
	}

	public void setMemberPOs(ArrayList<MemberPO> memberPOs) {
		this.memberPOs = memberPOs;
	}

	public ArrayList<AccountPO> getAccountPOs() {
		return accountPOs;
	}

	public void setAccountPOs(ArrayList<AccountPO> accountPOs) {
		this.accountPOs = accountPOs;
	}
}
