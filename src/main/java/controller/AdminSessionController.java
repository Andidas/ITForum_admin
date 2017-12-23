package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SessionService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.JsonResult;
import entity.Session;


@Controller
@RequestMapping("/session")
public class AdminSessionController {
	private SessionService sessionService;

	public SessionService getSessionService() {
		return sessionService;
	}
	@Resource
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	@RequestMapping(value="/getSessionPageTest",method=RequestMethod.GET)
	public @ResponseBody JsonResult<Session> getSessionPage(){
		PageHelper.startPage(1,5);
		List<Session> Sessionds=sessionService.queryAllSession();
		PageInfo<Session> page = new PageInfo<Session>(Sessionds);
		return new JsonResult<Session>(page);
	}
	
	/**
	 * 得到session分页
	 * @return
	 */
	@RequestMapping(value="/getSessionPage",method=RequestMethod.GET)
	public @ResponseBody JsonResult<Session> getSessionPage(int pageSize,int pageNum,
			String sort,String order,String info,String type){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		List<Session> Sessionds = null;
		System.out.println(type);
		if(info!=null&&!info.equals("")){
			if(type.equals("0")){
				Sessionds=sessionService.queryAllSession();
			}else if(type.equals("1")){
				Sessionds=sessionService.querySessionByName(info);
			}else if(type.equals("2")){
				Sessionds=sessionService.querySessionByProfile(info);
			}else if(type.equals("3")){
				Sessionds=sessionService.querySessionByMasterid(info);
			}
		}else{
			Sessionds=sessionService.queryAllSession();
		}
		PageInfo<Session> page = new PageInfo<Session>(Sessionds);
		return new JsonResult<Session>(page);
	}
	
	@RequestMapping(value="/deleteSession",method=RequestMethod.POST)
	public @ResponseBody boolean deleteSession(@RequestBody List<Integer> sids){
		System.out.println(sids);
		return 	sessionService.deleteSession(sids);
	}
}
