package beautynote.customer.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import beautynote.common.dao.AbstractDAO;
import beautynote.common.vo.CustomerVO;

@Service("CustomerService")
public class CustomerService extends AbstractDAO{
	 
	public String makeCusId() throws Exception {
		String returnValue;
		returnValue = (String)selectOne("customer.makeCusId");
		
		if(returnValue == null){
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			returnValue = format.format(date) + "0000";
		}
		
		return returnValue;
	}
	
    public void saveCustomer(CustomerVO vo) throws Exception {
    	insert("customer.saveCustomer", vo);
    }
}
