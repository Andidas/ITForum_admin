package service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import service.UserService;
import entity.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> queryUserList() {
		return userDao.queryUserList();
	}



	




	@Override
	public int updateUserState(User user) {
		return userDao.updateUserState(user);
	}
	@Override
	public List<User> queryUserByFuzzyName(String uname) {
		return userDao.queryUserByFuzzyName(uname);
	}
	@Override
	public List<User> queryUsersRegisterByToday() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String ttime = df.format(new Date());
		return userDao.queryUsersRegisterByToday(ttime);
	}
	
}
