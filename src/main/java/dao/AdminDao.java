package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Admin;


public interface AdminDao {
	@Select("select * from it_admin")
	List<Admin> findAll();
	
	@Select("select count(*) num from it_admin where aname=#{aname} and apassword = #{apassword}")
	int checkAdmin(Admin admin);

	@Insert("insert into it_admin(aname,apassword) values(#{aname},#{apassword}) ")
	int addAdmin(Admin admin);

	@Update("update it_admin set apassword=#{apassword} where aname=#{aname}")
	int UpdateAdminPassword(Admin admin);
	
}
