package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.User;
/**
 * 用户的数据库处理操作的接口
 * @author lwy
 *
 */

public interface UserDao {
	
	
	/**
	 * 查询用户数
	 * @return
	 */
	@Select("select count(*) from `user`")
	int queryUserCount();
	/**
	 * 查询所有的用户
	 * @return 用户组
	 */
	@Select("select uid,uname,upassword,uemail,uregdate,ubirthady,usex,uhead,usatement,ustate,upoint,uissectioner from user")
	List<User> queryUserList();
	
	/**
	 * 模糊查询用户名
	 * @param uname
	 * @return
	 */
	@Select("select * from `user` where uname like #{_parameter}")
	List<User> queryUserByFuzzyName(String uname);
	
	/**
	 * 更新用户的状态
	 * @param user
	 * @return
	 */
	@Update("update `user` set ustate=#{ustate} where uid = #{uid}")
	int updateUserState(User user);
	
	@Select("select * from `user` where uregdate >= #{_parameter}")
	List<User> queryUsersRegisterByToday(String ttime);
	
	
}