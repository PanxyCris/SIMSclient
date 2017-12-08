package vo.purchase;

import java.util.ArrayList;



import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.ViewObject;
import vo.commodity.CommodityItemVO;

public class PurchaseVO extends ViewObject{

	public String supplierID;
	public String supplier;  //��Ӧ��
	public Warehouse warehouse;
	public String operator;
	public ArrayList<CommodityItemVO> commodities;  //�����Ʒ�б�
	public double sum;
	public String remark;
	public BillType type;
	public BillState state;


	/**
	* @Description: TODO(������һ�仰�����������������)
	* @param @param supplierID
	* @param @param supplier
	* @param @param warehouse
	* @param @param operator
	* @param @param commodities
	* @param @param sum
	* @param @param remark
	* @param @param type
	* @param @param state    �趨�ļ�
	* @return   ��������
	* @throws
	*/
	public PurchaseVO(String supplierID, String supplier, Warehouse warehouse, String operator,
			ArrayList<CommodityItemVO> commodities, double sum, String remark, BillType type, BillState state) {
		super();
		this.supplierID = supplierID;
		this.supplier = supplier;
		this.warehouse = warehouse;
		this.operator = operator;
		this.commodities = commodities;
		this.sum = sum;
		this.remark = remark;
		this.type = type;
		this.state = state;
	}





	@Override
	public String toString() {
		return 	"[����ID=" + id + ", �ͻ�ID=" + supplierID + ", �ͻ�����=" + supplier
				+ ", �ֿ�=" + warehouse.value + ", ����Ա=" + operator + ", ��Ʒ�б�="
				+ commodities + ",\r\n��Ʒ�ܼ�=" + sum + ", ��ע="
				+ remark + ", ��������=" + type.value + ", ����״̬=" + state.value
				+ "]";
	}



}
