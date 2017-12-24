package testService;

import javax.annotation.Resource;

import org.junit.Test;

import service.SessionService;
import test.BaseJUnit4Test;

public class testSessionService extends BaseJUnit4Test{
	private SessionService sessionService;
	
	public SessionService getSessionService() {
		return sessionService;
	}
	@Resource
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	@Test
	public void testQueryAllSession() {
		System.out.println(sessionService.queryAllSession());
	}
		@Test
		public void testQuerySessionByName(){
			System.out.println(sessionService.querySessionByName("java"));
		}
		
		@Test
		public void testQuerySessionByProfile(){
			System.out.println(sessionService.querySessionByProfile("端"));
		}
}
