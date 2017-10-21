package SIMSclient.src.vo.bill;

public enum BillType {
	  INVENTORY_GIFT,     //库存赠送
      INVENTORY_BENEFIT,  //库存报溢
      INVENTORY_LOSS,     //库存报损
      INVENTORY_WARN,      //库存警戒

      RECEIVEMENT,         //收款单
      PAYMENT,            //付款单

      STOCKING,  //进货
      RETURNING, //退货
      SALES,      //销售
}
