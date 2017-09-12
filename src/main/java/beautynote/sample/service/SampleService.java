package beautynote.sample.service;

import beautynote.common.vo.CM_StoreVO;

import java.util.List;

public interface SampleService {
	List<CM_StoreVO> selectBoardList(CM_StoreVO vo) throws Exception;
}
