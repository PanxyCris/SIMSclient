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

	public ArrayList<SalesVO> showSaleApproving();
	public ArrayList<SalesVO> showSaleBackApproving();
	
	public ArrayList<SalesVO> showSalePass();
	public ArrayList<SalesVO> showSaleBackPass();
	
	public ArrayList<SalesVO> showSaleFailure();
	public ArrayList<SalesVO> showSaleBackFailure();
	
	public ArrayList<SalesVO> showSaleDraft();
	public ArrayList<SalesVO> showSaleBackDraft();
}
