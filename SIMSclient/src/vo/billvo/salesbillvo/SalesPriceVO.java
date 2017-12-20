package vo.billvo.salesbillvo;
/**
 * 用于返回根据策略判断后的代金券与价格折让
 * @author 潘星宇 2017.12.20
 *
 */

public class SalesPriceVO {

    private	double voucher;
    private double allowance;

    public SalesPriceVO(double voucher,double allowance){
    	this.allowance = allowance;
    	this.voucher = voucher;
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

}
