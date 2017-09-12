package beautynote.sample.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import beautynote.common.vo.CM_StoreVO;
import beautynote.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceimpl implements SampleService{

	@Resource(name="sampleDAO")
    private SampleDAO sampleDAO;
     
    @Override
    public List<CM_StoreVO> selectBoardList(CM_StoreVO vo) throws Exception {
        return sampleDAO.selectBoardList(vo);
    }
	 
}
