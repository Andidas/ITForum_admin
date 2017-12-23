package testService;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
//		assertTrue(service.updateUserState("", "1")>0);
	}
	
	@Test
	public void testQueryUserList() {
		assertTrue(service.queryUserList().size()>0);
		System.out.println(service.queryUserList());
	}

	@Test
	public void testQueryUser() {
		fail("尚未实现");
	}

	@Test
	public void testQueryUserOne() {
		fail("尚未实现");
	}

	@Test
	public void testCheckUser() {
		fail("尚未实现");
	}

	@Test
	public void testCheckUser_isSha_1() {
		fail("尚未实现");
	}

	@Test
	public void testIsNameExist() {
		fail("尚未实现");
	}

	@Test
	public void testUpdateUser() {
		fail("尚未实现");
	}

	@Test
	public void testAddUser() {
		fail("尚未实现");
	}

	@Test
	public void testModifyPasswordByEmail() {
		fail("尚未实现");
	}

}
