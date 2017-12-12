package bussinesslogicservice.salesblservice;

import java.util.ArrayList;

import vo.sale.SalesVO;

/**     
*  
* @author Lijie 
* @date 2017��12��11��    
*/
public interface SalesShowService {
	public ArrayList<SalesVO> showSale();
	public ArrayList<SalesVO> showSaleBack();

	public ArrayList<SalesVO> showSaleCommited();
	public ArrayList<SalesVO> showSaleBackCommited();
	
	public ArrayList<SalesVO> showSaleSuccess();
	public ArrayList<SalesVO> showSaleBackSuccess();
	
	public ArrayList<SalesVO> showSaleFail();
	public ArrayList<SalesVO> showSaleBackFail();
	
	public ArrayList<SalesVO> showSaleDraft();
	public ArrayList<SalesVO> showSaleBackDraft();
}
