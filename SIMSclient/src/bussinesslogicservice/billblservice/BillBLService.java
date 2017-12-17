package bussinesslogicservice.billblservice;

import dataenum.ResultMessage;
import vo.billvo.BillVO;

public interface BillBLService {

	public ResultMessage save(BillVO bill);

	public ResultMessage submit(BillVO bill);

	public ResultMessage update(BillVO bill);

	public void delete(BillVO bill);
}
