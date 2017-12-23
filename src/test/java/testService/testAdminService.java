package testService;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import service.AdminService;
import test.BaseJUnit4Test;

public class testAdminService extends BaseJUnit4Test{

	private AdminService service;
	public AdminService getService() {
		return service;
	}
	@Resource
	public void setService(AdminService service) {
		this.service = service;
	}

	@Test
	public void testFindAll() {
		System.out.println(service.findAll());
	}

	@Test
	public void testCheckAdmin() {
		assertTrue(service.checkAdmin("admin", "admin"));
	}

}
