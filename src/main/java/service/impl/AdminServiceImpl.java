package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.AdminService;
import dao.AdminDao;
import entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public List<Admin> findAll(){
			List<Admin> list = adminDao.findAll();
		return list;
	}
	@Override
	public boolean checkAdmin(String name ,String password){
		Admin admin = new Admin(name,password);
		int result = adminDao.checkAdmin(admin);
		return result>0;
	}
	@Override
	public boolean UpdateAdminPassword(Admin admin) {
		// TODO 自动生成的方法存根
		return false;
	}
	
}
