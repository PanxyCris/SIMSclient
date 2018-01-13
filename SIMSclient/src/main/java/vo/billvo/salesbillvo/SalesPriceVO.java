package vo.billvo.salesbillvo;

import java.util.ArrayList;

import vo.commodityvo.GiftVO;

/**
 * ���ڷ��ظ��ݲ����жϺ�Ĵ���ȯ��۸�����
 * 
 * @author ������ 2017.12.20
 *
 */

public class SalesPriceVO {

	private double voucher;
	private double allowance;
	private ArrayList<GiftVO> gifts;

	public SalesPriceVO(double voucher, double allowance, ArrayList<GiftVO> gifts) {
		this.allowance = allowance;
		this.voucher = voucher;
		this.setGifts(gifts);
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

	public ArrayList<GiftVO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftVO> gifts) {
		this.gifts = gifts;
	}

}
