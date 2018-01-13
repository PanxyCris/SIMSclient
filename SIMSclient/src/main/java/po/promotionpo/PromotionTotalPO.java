package po.promotionpo;
/**
* ���ݹ������Ʒ�ܼۣ��ƶ����ã���Ʒ�����ʹ���ȯ
* @author ������
* @date 2017��12��27��
*/
import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.PromotionType;
import po.commoditypo.GiftPO;

public class PromotionTotalPO extends PromotionPO {


	private static final long serialVersionUID = -710887490086473194L;
	private Double total;
	private Double voucher;
	private ArrayList<GiftPO> gifts;

	public PromotionTotalPO(String id,LocalDate beginDate,LocalDate endDate, Double total,
			Double voucher, ArrayList<GiftPO> gifts) {
		super(id,beginDate,endDate,PromotionType.SUM_PROMOTION);
		this.setVoucher(voucher);
		this.setGifts(gifts);
		this.setTotal(total);
	}


	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public ArrayList<GiftPO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	}

}
