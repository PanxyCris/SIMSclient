package SIMSclient.src.bussinesslogic_mock.mfdocbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.xjfydbl.XJFYDBL;
import SIMSclient.src.vo.makefinancialdoc.XJFYDVO;

public class XJFYDBL_mock extends XJFYDBL{

	XJFYDVO xjfydVO;
	
	public XJFYDBL_mock() {
	}
	
	@Override
	public ResultMessage newBuild(XJFYDVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(XJFYDVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(XJFYDVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public XJFYDVO find(String message) {
		return xjfydVO;
	}

	@Override
	public ResultMessage commit(XJFYDVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

}
