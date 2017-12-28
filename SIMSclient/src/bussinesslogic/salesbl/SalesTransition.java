package bussinesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import bussinesslogic.common.CommodityItemTran;
import bussinesslogic.memberbl.MemberInfo;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commodity.CommodityItemPO;
import po.sales.SalesPO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;


/**
 * ����PO��VO���໥ת��
 */
public class SalesTransition {

	private static MemberInfo mi;
	public static SalesPO VOtoPO(SalesVO vo) {
		mi = new MemberInfo();
		String id = vo.getId();            
		String retailer = vo.getRetailer(); // �����̿ͻ�
		String retailerId = mi.getId(retailer);
		String saleMan = vo.getSaleMan(); // ҵ��Ա
		String operator = vo.getOperator(); // ����Ա
		Warehouse warehouse = vo.getWarehouse();
		ArrayList<CommodityItemPO> commodity = CommodityItemTran.VOtoPO(vo.getCommodity());
		double beforePrice = vo.getBeforePrice();
		double allowance = vo.getAllowance(); // ����
		double voucher = vo.getVoucher(); // ʹ�ô���ȯ���
		double afterPrice = vo.getAfterPrice();
		String remark = vo.getNote(); // ��ע
		BillType type = vo.getType();
		BillState state = vo.getState();
		return new SalesPO(id, retailerId, retailer, saleMan, operator, warehouse, commodity, beforePrice,
				allowance, voucher, afterPrice, remark, type, state);
	}

	public static SalesVO POtoVO(SalesPO po) {
		String id = po.getId();
		String retailerId = po.getClientId();
		String retailer = po.getClientName();
		String salesMan = po.getSaleMan();
		String operator = po.getOperator();
		Warehouse warehouse = po.getWarehouse();
		ArrayList<CommodityItemVO> commodity = CommodityItemTran.POtoVO(po.getCommodities());
		double beforePrice = po.getBeforePrice();
		double allowance = po.getAllowance(); // ����
		double voucher = po.getVoucher(); // ʹ�ô���ȯ���
		double afterPrice = po.getAfterPrice();
		String remark = po.getRemark(); // ��ע
		BillType type = po.getType();
		BillState state = po.getState();
		return new SalesVO(id, retailer, salesMan, operator, warehouse,
				commodity, beforePrice, allowance, voucher, afterPrice, remark, state, type);
	}
}
