package testService;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import service.PrivateLetterService;
import test.BaseJUnit4Test;

public class testPrivateLetter extends BaseJUnit4Test{

	private PrivateLetterService service ;
	
	public PrivateLetterService getService() {
		return service;
	}
	@Resource
	public void setService(PrivateLetterService service) {
		this.service = service;
	}

	@Test
	public void testUpdateAllReaded() {
		fail("尚未实现");
	}

	@Test
	public void testEvenReaded() {
		fail("尚未实现");
	}

	@Test
	public void testFindAll() {
		fail("尚未实现");
	}

	@Test
	public void testBatchDelete() {
		fail("尚未实现");
	}

	@Test
	public void testBatchAdd() {
		fail("尚未实现");
	}

	@Test
	public void testDeleteFriendsLetter() {
		fail("尚未实现");
	}

	@Test
	public void testQueryAllSystemMessage() {
		assertTrue(service.queryAllSystemMessage().size()>0);
		System.out.println(service.queryAllSystemMessage());
		
	}
	
	@Test 
	public void sendLetterToAllUser(){
		service.sendSystemInfoToAllUser("系统消息：提前祝大家新年快乐");
	}

}
