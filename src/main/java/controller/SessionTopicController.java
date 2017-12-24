package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SessionService;
import service.TopicService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.JsonResult;
import entity.Session;
import entity.Topic;


@Controller
@RequestMapping("/session")
public class SessionTopicController {
	private TopicService topicService;
	private SessionService sessionService;

	@RequestMapping(value="/getTopicPageTest",method=RequestMethod.GET)
	public @ResponseBody JsonResult<Topic> getTopicPage(){
		PageHelper.startPage(1,5);
		List<Topic> Sessionds=topicService.queryTopicAll();
		PageInfo<Topic> page = new PageInfo<Topic>(Sessionds);
		return new JsonResult<Topic>(page);
	}
	
	/**
	 * 获得今天发布的帖子
	 * @return
	 */
	@RequestMapping(value="/getTopicRegisterByToday",method=RequestMethod.GET)
	public @ResponseBody List<Topic> getTopicRegisterByToday(){
		return  topicService.queryTopicsRegisterByToday();
	}
	
	
	/**
	 * 得到topic分页
	 * @return
	 */
	@RequestMapping(value="/getTopicPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<Topic> getTopicPage(int pageSize,int pageNum,
			String sort,String order,String info,String type){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		
		List<Topic> Sessionds = getTopicResult(info,type);
		PageInfo<Topic> page = new PageInfo<Topic>(Sessionds);
		return new JsonResult<Topic>(page);
	}	
	
	/**
	 * 删除topic
	 * @param sids
	 * @return
	 */
	@RequestMapping(value="/deleteTopic",method=RequestMethod.POST)
	public @ResponseBody boolean deleteTopic(@RequestBody List<Integer> tids){
		return 	topicService.deleteTopic(tids);
	}
	
	/**
	 * 得到session分页
	 * @return
	 */
	@RequestMapping(value="/getSessionPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<Session> getSessionPage(int pageSize,int pageNum,
			String sort,String order,String info,String type){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		
		List<Session> Sessionds = getSessionResult(info,type);
		PageInfo<Session> page = new PageInfo<Session>(Sessionds);
		return new JsonResult<Session>(page);
	}
	/**
	 * 
	 * @param info 内容
	 * @param type 类型。0,1,2,3
	 * @return
	 */
	private List<Topic> getTopicResult(String info,String type){
		if(info!=null&&!info.equals("")){
			if(type.equals("0")){
				return topicService.queryTopicAll();
			}else if(type.equals("1")){
				return topicService.queryTopicByTitle(info);
			}else if(type.equals("2")){
				return topicService.queryTopicByContent(info);
			}else if(type.equals("3")){
				return topicService.queryTopicByMaster(info);
			}else {
				return null;
			}
		}else{
			return topicService.queryTopicAll();
		}
	}
	
	
	/**
	 * 
	 * @param info 内容
	 * @param type 类型。0,1,2,3
	 * @return
	 */
	private List<Session> getSessionResult(String info,String type){
		if(info!=null&&!info.equals("")){
			if(type.equals("0")){
				return sessionService.queryAllSession();
			}else if(type.equals("1")){
				return sessionService.querySessionByName(info);
			}else if(type.equals("2")){
				return sessionService.querySessionByProfile(info);
			}else if(type.equals("3")){
				return sessionService.querySessionByMasterid(info);
			}else {
				return null;
			}
		}else{
			return sessionService.queryAllSession();
		}
	}
	
	
	/**
	 * 删除版块
	 * @param sids
	 * @return
	 */
	@RequestMapping(value="/deleteSession",method=RequestMethod.POST)
	public @ResponseBody boolean deleteSession(@RequestBody List<Integer> sids){
		return 	sessionService.deleteSession(sids);
	}
	
	public SessionService getSessionService() {
		return sessionService;
	}
	@Resource
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
}
