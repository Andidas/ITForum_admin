package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Admin;


public interface AdminDao {
	@Select("select * from it_admin")
	List<Admin> findAll();
	
	@Select("select count(*) num from it_admin where aname=#{aname} and apassword = #{apassword}")
	int checkAdmin(Admin admin);
}
