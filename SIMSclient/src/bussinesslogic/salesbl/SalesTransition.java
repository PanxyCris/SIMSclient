package bussinesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import bussinesslogic.common.CommodityItemTran;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import po.commodity.CommodityItemPO;
import po.sales.SalesPO;
import vo.commodity.CommodityItemVO;
import vo.sale.SalesVO;


/**
 * ����PO��VO���໥ת��
 */
public class SalesTransition {

	public static SalesPO VOtoPO(SalesVO vo) {
		String id = vo.getId();
		String retailerId = vo.retailerID;
		String retailer = vo.retailer; // �����̿ͻ�
		String saleMan = vo.saleMan; // ҵ��Ա
		String operator = vo.operator; // ����Ա
		Warehouse warehouse = vo.warehouse;
		ArrayList<CommodityItemPO> commodity = CommodityItemTran.VOtoPO(vo.commodity);
		double beforePrice = vo.beforePrice;
		double allowance = vo.allowance; // ����
		double voucher = vo.voucher; // ʹ�ô���ȯ���
		double afterPrice = vo.afterPrice;
		String remark = vo.remark; // ��ע
		BillType type = vo.type;
		BillState state = vo.state;
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
		return new SalesVO(id, retailerId, retailer, salesMan, 
				operator, warehouse, commodity, beforePrice, allowance, voucher, afterPrice, remark, state, type);
	}
}
