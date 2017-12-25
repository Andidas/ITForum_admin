package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import service.AdminService;
import entity.Admin;

 
/**
 * @author 刘伟艺
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.POST)
	@ResponseBody
	public boolean resetPassword(@RequestBody Admin admin){
		return adminService.UpdateAdminPassword(admin);
	}
	/**
	 * 注销admin用户
	 * @return
	 */
	@RequestMapping("/logout")
	public String adminLogout(){
		getSession().setAttribute("nowLoginUser_email",null);
		return "redirect:/admin.html";
	}

	/**
	 * ajax 得到admin的数据
	 * @return
	 */
	@RequestMapping("/getAdminParam")
	public @ResponseBody Map<String,Object> getAdminParam(){
		HashMap<String,Object> adminParam = new HashMap<String,Object>();
		Object email = getSession().getAttribute("nowLoginUser_email");
		adminParam.put("email", email);
		return adminParam;
	}
	
	@RequestMapping("index")
	public String adminIndex() {
		return "admin/index";
	}

	@RequestMapping("/admin_signIn")
	public String adminLogin() {
		return "admin/admin_signIn";
	}
	
	
	@RequestMapping("/main")
	public String adminMain() {
		return "admin/main";
	}
	

	
	@RequestMapping("/admin_signUp")
	public String adminRegister() {
		return "admin/admin_signUp";
	}

	@RequestMapping("/admin_resetPassword")
	public String adminResetPassword() {
		return "admin/admin_resetPassword";
	}

	@RequestMapping("/help")
	public String adminHelp() {
		return "admin/help";
	}

	@RequestMapping("/info_system")
	public String adminInfoSystem() {
		return "admin/info_system";

	}

	@RequestMapping("/info_activity")
	public String adminInfoActivity() {
		return "admin/info_activity";
	}

	@RequestMapping("/info_feedback")
	public String adminInfoFeedback() {
		return "admin/info_feedback";
	}

	@RequestMapping("/privacy_policy")
	public String adminPrivatePolicy() {
		return "admin/privacy_policy";
	}

	@RequestMapping("/topic")
	public String adminRecomendObject() {
		return "admin/topic";
	}

	@RequestMapping("/terms_and_conditions")
	public String adminTermsAndConditions() {
		return "admin/terms_and_conditions";
	}

	@RequestMapping("/session")
	public String adminSession() {
		return "admin/session";
	}
	
	@RequestMapping("/reply")
	public String adminReply() {
		return "admin/reply";
	}

	/**
	 * 用户信息页面
	 * @return
	 */
	@RequestMapping("/user_list")
	public String adminUserList() {
		return "admin/user_list";
	}

	@RequestMapping("/403")
	public String admin403() {
		return "403";
	}

	@RequestMapping("/404")
	public String admin404() {
		return "404";
	}

	@RequestMapping("/500")
	public String admin500() {
		return "500";
	}

	@RequestMapping("/503")
	public String admin503() {
		return "503";
	}

	
	/**
	 * get Session
	 * @return HttpSession
	 */
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	/**
	 * get Request
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest();
	}

	public AdminService getAdmin() {
		return adminService;
	}

	@Resource
	public void setAdmin(AdminService adminService) {
		this.adminService = adminService;
	}
	
	private AdminService adminService;
	
}
