package controller;

import java.security.GeneralSecurityException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import service.AdminService;
import utils.SendEmail;
import dao.AdminDao;
import entity.Admin;

/**
 * @author 刘伟艺
 *
 */
@Controller
@RequestMapping("/AdminMaintain")
public class AdminMaintainController {
	
	/**
	 * 跳到登录界面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String Welcome(){
		getSession().setAttribute("nowLoginUser_email",null);
		return "redirect:/admin.html";
	}
	
	/**
	 * 管理员注册
	 * @return
	 */
	@RequestMapping("/registerAdmin")
	@ResponseBody
	public boolean registerAdmin(String email,String password){
		Admin admin = new Admin(email,password);
		return adminService.addAdmin(admin);
	}
	
	/**
	 * 跳到注册页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	@ResponseBody
	public boolean Register(){
		return true;
	}
	
	/**
	 * 鼠标离开验证码框的时候，自动校验验证码
	 * @param captcha
	 * @return
	 */
	@RequestMapping("/ensureCapthca")
	@ResponseBody
	public boolean ensureCapthca(String captcha){
		String cap = (String) getSession().getAttribute("emailCaptcha");
		System.out.println(cap);
		System.out.println(captcha);
		return cap.equals(captcha);
	}
	/**
	 * 获取邮箱验证
	 * @param email
	 * @return
	 * @throws GeneralSecurityException
	 */
	@RequestMapping("{email}/getEmailCaptcha")
	@ResponseBody
	public boolean getEmailCaptcha(@PathVariable String email) throws GeneralSecurityException{
		String captcha = SendEmail.generateCAPTCHA();
		String content = SendEmail.getContent(captcha);
		String emailHead = "画缘注册验证";
		boolean result =SendEmail.sendEmail(email, emailHead, content);
		getSession().setAttribute("emailCaptcha", captcha);
		return result;
	}
	/**
	 * admin登录
	 * @param String email 
	 * @param String password
	 * @param session
	 * @return
	 */
	@RequestMapping("{email}/{password}/login")
	public @ResponseBody String adminLoginPage(
			@PathVariable String email,
			@PathVariable String password) {
		boolean isLogin = adminService.checkAdmin(email, password);
		if (isLogin) {
			getSession().setAttribute("nowLoginUser_email", email);
			return email;
		} else {
			return "false";
		}
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
	

	private AdminService adminService;


	public AdminService getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	
}
