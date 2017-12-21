package bussinesslogicservice.examineblservice;
/**
*  �����ӿ�
* @author Lijie
* @date 2017��12��17��
*/

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import vo.ViewObject;
import vo.billvo.BillVO;

public interface ExamineBLService<B extends BillVO> {

	public ResultMessage updateBill(B vo, BillType type);

	public ResultMessage passBills(ArrayList<B> vos, BillType type);

	public ResultMessage notPassBills(ArrayList<B> vos, BillType type);

	public ArrayList<B> getCommitedBills();

}
