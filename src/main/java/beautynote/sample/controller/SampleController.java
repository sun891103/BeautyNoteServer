package beautynote.sample.controller;

import beautynote.common.vo.CM_StoreVO;
import beautynote.sample.service.SampleService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleService")
    private SampleService sampleService;
     
    @RequestMapping(value="/sample/openSampleBoardList.do")
    public ModelAndView openSampleBoardList(CM_StoreVO vo) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
        
        List<CM_StoreVO> list = sampleService.selectBoardList(vo);
        mv.addObject("list", list);
        mv.setViewName("login");
         
        return mv;
    }
}
