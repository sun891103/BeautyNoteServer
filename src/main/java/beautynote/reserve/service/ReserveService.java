package beautynote.reserve.service;

import java.util.List;

import org.springframework.stereotype.Service;

import beautynote.common.dao.AbstractDAO;
import beautynote.common.vo.ReserveVO;

@Service("ReserveService")
public class ReserveService extends AbstractDAO{
	
    @SuppressWarnings("unchecked")
	public List<ReserveVO> selReserve() throws Exception {
    	return selectList("reserve.selReserve");
    }
}
