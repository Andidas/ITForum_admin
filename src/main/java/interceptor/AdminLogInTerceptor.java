package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截�?
 * @author lwy
 *
 */
@Component
public class AdminLogInTerceptor implements HandlerInterceptor{
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		String email = (String) session.getAttribute("nowLoginUser_email");
		if(email!=null &&email!=""){
			return true;
		}else{
			response.getWriter().print("<script>alert('请先登录!');location.href='../AdminMaintain/toLogin.htm';</script>");
			
			return false;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mav) throws Exception {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("nowLoginUser_email");
		if(email!=null &&email!=""){
			 	
		}else{
			response.getWriter().print("<script>alert('login first!');location.href='../AdminMaintain/toLogin.htm';</script>");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		
	}

}
