package testService;

import javax.annotation.Resource;

import org.junit.Test;

import test.BaseJUnit4Test;
import dao.SessionDao;

public class testSessionService extends BaseJUnit4Test{
	private SessionDao sessionDao;
	public SessionDao getSessionDao() {
		return sessionDao;
	}
	@Resource
	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}
	@Test
	public void testQueryAllSession() {
		System.out.println(sessionDao.queryAllSession());
	}

}
