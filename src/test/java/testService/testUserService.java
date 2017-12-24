package testService;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import service.UserService;
import test.BaseJUnit4Test;

public class testUserService extends BaseJUnit4Test{
	private UserService service ;
		
	public UserService getService() {
		return service;
	}

	@Resource
	public void setService(UserService service) {
		this.service = service;
	}
	@Test
	public void testQueryUserByName(){
		System.out.println(service.queryUserByFuzzyName("%小%"));
	}
	@Test
	public void testUpdateUserState(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String ttime = df.format(new Date());
		System.out.println(ttime);
	}
	
	@Test
	public void testQueryUserList() {
		assertTrue(service.queryUserList().size()>0);
		System.out.println(service.queryUserList());
	}

	@Test 
	public void queryUsersRegisterByToday(){
		System.out.println(service.queryUsersRegisterByToday());
		System.out.println(service.queryUsersRegisterByToday().size());
	}

}
