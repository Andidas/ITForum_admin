package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SessionService;


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
	public void getSession(){
		
	}
}
