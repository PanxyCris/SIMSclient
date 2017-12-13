package bussinesslogic.salesbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import bussinesslogic.memberbl.MemberInfo;
import bussinesslogic.promotionbl.PromotionInfo;
import bussinesslogic.userbl.UserInfo;
import bussinesslogicservice.salesblservice.Sale_MemberInfo;
import bussinesslogicservice.salesblservice.Sale_PromotionInfo;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionMemberVO;
import vo.promotion.PromotionPricePacksVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesInputVO;
import vo.sale.SalesVO;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.salesdataservice.SalesDataService;

/**
 * 
* @ClassName: Sales 
* @Description: �����������񣬴������ۣ��˻�����
* @date 2017��12��1�� ����7:00:29 
*
 */
public class Sales {

	private BillType type;
	private String ID;
	private ArrayList<String> IDList;  
	private ArrayList<Integer> NumberList;
	private SalesList list;  //���۵�
	private RemoteHelper remoteHelper;
	
	private SalesDataService saledataservice;  //���۵�����
	private Sale_PromotionInfo promotioninfo;  //������Ϣ
	private Sale_MemberInfo memberinfo;  //��Ա��Ϣ
	private UserInfo userinfo;  // �û���Ϣ
	
	public Sales() {
		this.IDList = new ArrayList<>();
		this.NumberList = new ArrayList<>();
		this.promotioninfo = new PromotionInfo();
		this.list = new SalesList();
		this.saledataservice = RemoteHelper.getInstance().getSalesDataService();
	}
	
	public String getSaleID() throws RemoteException {
		this.type = BillType.SALESBILL;
		this.ID = saledataservice.getSaleID();
		return ID;
	}

	public String getSaleBackID() throws RemoteException {
		this.type = BillType.SALESBACKBILL;
		this.ID = saledataservice.getSaleBackID();
		return ID;
	}
	
	/*�������۵�*/
	public SalesPO createSale() throws RemoteException {
		memberinfo = new MemberInfo();
		userinfo = new UserInfo();
		return new SalesPO(ID, list.getMemberID(), memberinfo.getMember(list.getMemberID()),
				memberinfo.getSaleMan(list.getMemberID()), 
				userinfo.getOperator(), list.getWareHouse(), list.getCommodities(), list.getBeforePrice(), 
				list.getAllowance(), list.getVoucher(), list.getAfterPrice(), list.getRemark(), type);
	}
	             
	
	public void addCommodities(CommodityItemVO vo) throws RemoteException {
		SalesLineItem item = new SalesLineItem(vo.getId(), vo.getNumber(), vo.getPrice(), vo.getRemark());
		list.add(item);
		IDList.add(vo.getId());
		NumberList.add(vo.getNumber());
	}
	
	
	public ArrayList<PromotionPricePacksVO> showPricePacks() throws RemoteException {
		return promotioninfo.showPricePacks();
	}
    
   
	public void addPricePacks(String id) throws RemoteException {
		PromotionPricePacksVO vo = promotioninfo.findPricePacks(id);
		ArrayList<CommodityItemVO> commodities = vo.pricePacks;
		for (CommodityItemVO c: commodities) {
			addCommodities(c);
		}
		list.setVoucher(vo.beforeTotal - vo.afterTotal);
	}
	
	public ArrayList<PromotionTotalVO> FindTotalPromotion() throws RemoteException {
		return promotioninfo.findTotalPromotion(ID, list.getBeforePrice());
	}
	
	public ArrayList<PromotionMemberVO> FindMemberPromotion() throws RemoteException {
		return promotioninfo.findMemberPromotion(ID, list.getMemberID());
	}
	
	public double setPromotion(String id) throws RemoteException {
		double discount = promotioninfo.getAllowance(id);
		if (discount == 0) discount = 1;
		double amount = (1 - discount) * list.getBeforePrice();
		DecimalFormat df = new DecimalFormat("0.00");
		double allowance = Double.parseDouble(df.format(amount));
		list.setAllowance(allowance);
		return allowance;
	}
	
	public void addMembers(String id) throws RemoteException {
		list.setMemberID(id);
	}

	
	
    public SalesVO save(SalesInputVO vo) throws RemoteException {
    	inputInfo(vo);
    	SalesPO po = createSale();
    	po.setState(BillState.DRAFT);
    	saledataservice.insertSale(po);
		return SalesTransition.POtoVO(po);
    }
    
    public SalesVO submit(SalesInputVO vo) throws RemoteException {
    	inputInfo(vo);
    	SalesPO po = createSale();
    	po.setState(BillState.COMMITED);
    	saledataservice.insertSale(po);
		return SalesTransition.POtoVO(po);
    }
    
    public ResultMessage updateDraft(SalesVO vo) throws RemoteException {
		SalesPO po = SalesTransition.VOtoPO(vo);
		return saledataservice.updateSale(po);
	}

	public ResultMessage submitDraft(String id) throws RemoteException {
		ArrayList<SalesPO> list = saledataservice.findSale(id, FindSalesType.ID);
		SalesPO po = null;
		for (SalesPO p:list) {
			if (id.equals(p.getId())) {
				po = p;
				break;
			}
		}
		po.setState(BillState.COMMITED);
		return saledataservice.updateSale(po);
	}
	
    public void inputInfo(SalesInputVO vo) {
    	list.setAllowance(vo.allowance);
    	list.setWareHouse(vo.warehouse);
    	list.setRemark(vo.remark);
    	list.setVoucher(vo.voucher);
    }
}
