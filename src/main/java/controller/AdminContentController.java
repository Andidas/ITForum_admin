package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.PrivateLetterService;
import service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.JsonResult;
import entity.PrivateLetter;
import entity.User;

@Controller
@RequestMapping("/content")
public class AdminContentController {
	private PrivateLetterService privateLetterService ;
	private UserService userService;
	
	/**
	 * 获得用户分页
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/getUserPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<User> getUserPage(int pageSize,int pageNum,
			String sort,String order,String uname){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		List<User> users = null;
		if(uname!=null&&!uname.equals("")){
			users=userService.queryUserByFuzzyName("%"+uname+"%");
		}else{
			users=userService.queryUserList();			
		}
		PageInfo<User> page = new PageInfo<User>(users);
		return new JsonResult<User>(page);
	}
	
	/**
	 * 获得今天注册的用户
	 * @return
	 */
	@RequestMapping(value="/getUserRegisterByToday",method=RequestMethod.GET)
	public @ResponseBody List<User> getUserRegisterByToday(){
		return  userService.queryUsersRegisterByToday();
	}
	
	/**
	 * 更新用户状态
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/updateUserState",method=RequestMethod.POST)
	public @ResponseBody boolean updateUserState(@RequestBody User user){
		return userService.updateUserState(user)>0;
	}
	
	/**
	 * 获取系统信息分页
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/getSystemInfoPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<PrivateLetter> getSystemInfoPage(int pageSize,int pageNum,
			String sort,String order){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		List<PrivateLetter> PrivateLetters=privateLetterService.queryAllSystemMessage();
		PageInfo<PrivateLetter> page = new PageInfo<PrivateLetter>(PrivateLetters);
		return new JsonResult<PrivateLetter>(page);
	}
	

	
	/**
	 * 获得反馈信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/getFeedbackPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<PrivateLetter> getFeedbackPage(int pageSize,int pageNum,
			String sort,String order){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		List<PrivateLetter> PrivateLetters=privateLetterService.queryAllFeedback();
		PageInfo<PrivateLetter> page = new PageInfo<PrivateLetter>(PrivateLetters);
		return new JsonResult<PrivateLetter>(page);
	}
	
	
	
	/**
	 * 反馈信息标记为已读
	 * @param fids
	 * @return
	 */
	@RequestMapping(value="/Feedback_markReaded",method=RequestMethod.POST)
	public @ResponseBody boolean Feedback_markReaded(@RequestBody List<Integer> fids){
		
		return privateLetterService.markReaded(fids);
	}
	
	/**
	 * 发送系统信息
	 * @param letter
	 * @return
	 */
	@RequestMapping(value="/sendSystemLetter",method=RequestMethod.POST)
	public @ResponseBody boolean sendSystemLetter(@RequestBody PrivateLetter letter){
		List<Integer> pid = new ArrayList<Integer>();
		pid.add(letter.getPid());
		privateLetterService.markReaded(pid);
		return privateLetterService.batchAdd(String.valueOf(letter.getPuid()),String.valueOf(letter.getPtouid()),letter.getMessage_type(),"系统消息："+letter.getPcontent());
	}
	
	/**
	 * 发送消息给所有人
	 * @param content
	 * @return
	 */
	@RequestMapping("{content}/sendLetterToAllUser")
	public @ResponseBody boolean sendLetterToAllUser(@PathVariable String content){
		
		return privateLetterService.sendSystemInfoToAllUser(content);
	}
	

	public PrivateLetterService getPrivateLetterService() {
		return privateLetterService;
	}
	@Resource
	public void setPrivateLetterService(PrivateLetterService privateLetterService) {
		this.privateLetterService = privateLetterService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
