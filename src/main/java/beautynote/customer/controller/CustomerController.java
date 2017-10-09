package beautynote.customer.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beautynote.common.util.Utils;
import beautynote.common.vo.CustomerVO;
import beautynote.customer.service.CustomerService;

@Controller
public class CustomerController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="CustomerService")
    private CustomerService customerService;
     
    @RequestMapping(value="/saveCustomer.do")
    public void saveCustomer(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> params) throws Exception{
        String sResultCode = "9999";
        String sResultMessage = "관리자에게 문의하세요";
        String sResultJson = "";
        
        try {
        	CustomerVO vo = new CustomerVO();
        	vo.setCusId(customerService.makeCusId());
        	vo.setName(params.get("name"));
        	vo.setBirth(params.get("birth"));
        	vo.setTelNo(params.get("telNo"));
        	vo.setAddress(params.get("address"));
        	vo.setStatus(params.get("status"));
        	vo.setGender(params.get("gender"));
        	vo.setSmsAgreeYn(params.get("smsAgreeYn"));
        	vo.setPoint(params.get("point"));
        	
        	customerService.saveCustomer(vo);
        	
        	sResultCode = "0000";
        } catch (Exception e) {
        	sResultCode = "9999";
        	sResultMessage = e.toString();
        } finally {
        	Utils.sendResultJson(response, sResultJson, sResultCode, sResultMessage);
        }
    }
}
