package beautynote.reserve.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beautynote.common.util.Utils;
import beautynote.common.vo.ReserveVO;
import beautynote.reserve.service.ReserveService;

@Controller
public class ReserveController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="ReserveService")
    private ReserveService ReserveService;
     
    @RequestMapping(value="/selReserve.do")
    public void selReserve(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> params) throws Exception{
        String sResultCode = "9999";
        String sResultMessage = "관리자에게 문의하세요";
        String sResultJson = "";
        
        try {        	
        	List<ReserveVO> returnValue = ReserveService.selReserve();
        	
        	sResultCode = "0000";
        	
        	sResultJson = Utils.makeJsonString(returnValue.size(), returnValue, null);
        } catch (Exception e) {
        	sResultCode = "9999";
        	sResultMessage = e.toString();
        } finally {
        	Utils.sendResultJson(response, sResultJson, sResultCode, sResultMessage);
        }
    }
}
