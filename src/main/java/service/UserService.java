package service;

import java.util.List;

import entity.User;
/**
 * @author 刘伟艺
 * 用户服务接口
 */
public interface UserService {
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> queryUserList();
	
	/**
	 * 修改用户状态
	 * @param uid
	 * @param ustate
	 * @return
	 */
	public int updateUserState(User user);
	
	/**
	 * 按照名字模糊查询用户
	 * @param uname
	 * @return
	 */
	public List<User> queryUserByFuzzyName(String uname);

	/**
	 * 今天注册的用户
	 * @return
	 */
	public List<User> queryUsersRegisterByToday();

	/**
	 * 获得用户数
	 * @return
	 */
	public int queryUserCount();
	
}