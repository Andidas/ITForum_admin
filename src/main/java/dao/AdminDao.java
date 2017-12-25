package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Admin;


public interface AdminDao {
	/**
	 * 查询所有
	 * @return
	 */
	@Select("select * from it_admin")
	List<Admin> findAll();
	
	/**
	 * 检查是否存在
	 * @param admin
	 * @return
	 */
	@Select("select count(*) num from it_admin where aname=#{aname} and apassword = #{apassword}")
	int checkAdmin(Admin admin);

	/**
	 * 新增
	 * @param admin
	 * @return
	 */
	@Insert("insert into it_admin(aname,apassword) values(#{aname},#{apassword}) ")
	int addAdmin(Admin admin);

	/**
	 * 更新密码
	 * @param admin
	 * @return
	 */
	@Update("update it_admin set apassword=#{apassword} where aname=#{aname}")
	int UpdateAdminPassword(Admin admin);
	
}
