package beautynote.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class LoginCheckFilter implements Filter {
	
	private static final Logger                loMeLogger         = Logger.getLogger(LoginCheckFilter.class);
	
	public void init(FilterConfig config) throws ServletException {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		loMeLogger.info("여기서 세션 체크 하면됨");
		chain.doFilter(request, response);
		/*HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		if(session != null){
			chain.doFilter(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sample/openSampleBoardList.do"); 
			dispatcher.forward(request, response); 
		}*/
	}
	
	public void destroy() { }
}
