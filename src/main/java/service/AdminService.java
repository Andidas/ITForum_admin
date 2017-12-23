package service;

import java.util.List;

import entity.Admin;

public interface AdminService {
	
	 List<Admin> findAll();
	 boolean checkAdmin(String name ,String password);
	 boolean UpdateAdminPassword(Admin admin);
	
}
