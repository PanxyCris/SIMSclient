package bussinesslogicservice.examineblservice;
/**
*  �����ӿ�
* @author Lijie
* @date 2017��12��17��
*/

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import vo.ViewObject;
import vo.billvo.BillVO;

public interface ExamineBLService<B extends BillVO> {

	public ResultMessage updateBill(B vo);

	public ResultMessage passBills(ArrayList<B> vos);

	public ResultMessage notPassBills(ArrayList<B> vos);

	public ArrayList<B> getCommitedBills();

	public ArrayList<B> find(String info,FindBillType type);//���ύ�ĵ���

}
