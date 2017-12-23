package service;

import java.util.List;

import entity.Admin;

public interface AdminService {
	
	 /**
	  * 查询所有
	 * @return
	 */
	List<Admin> findAll();
	 /**
	  * 检查管理员是否存在
	 * @param name
	 * @param password
	 * @return
	 */
	boolean checkAdmin(String name ,String password);
	 /**
	  * 更新管理员密码
	 * @param admin
	 * @return
	 */
	boolean UpdateAdminPassword(Admin admin);
	 /**
	  * 新增管理员
	 * @param admin
	 * @return
	 */
	boolean addAdmin(Admin admin);
	
	
}
