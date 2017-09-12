package beautynote.sample.dao;

import beautynote.common.dao.AbstractDAO;
import beautynote.common.vo.CM_StoreVO;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
    public List<CM_StoreVO> selectBoardList(CM_StoreVO vo) throws Exception{
        return (List<CM_StoreVO>)selectList("sample.selectBoardList", vo);
    }
 
}
