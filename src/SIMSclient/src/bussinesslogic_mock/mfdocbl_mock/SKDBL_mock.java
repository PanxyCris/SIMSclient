package SIMSclient.src.bussinesslogic_mock.mfdocbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.skdbl.SKDBL;
import SIMSclient.src.vo.makefinancialdoc.SKDVO;

public class SKDBL_mock extends SKDBL{

	SKDVO skdVO;
	
	public SKDBL_mock(){
		
	}
	
	@Override
	public ResultMessage newBuild(SKDVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(SKDVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(SKDVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public SKDVO find(String message) {
		return skdVO;
	}

	@Override
	public ResultMessage commit(SKDVO skdVO) {
		return ResultMessage.SUCCESS;
	}
	
}
