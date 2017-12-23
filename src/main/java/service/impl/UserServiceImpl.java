package service.impl;

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
	public User queryUser(String email) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public User queryUserOne(String uid) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean checkUser(String email, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean checkUser_isSha_1(String email, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean isNameExist(String uname) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public User updateUser(int uid, String uname, String uhead, String uemail,
			String usex, String ubirthady, String usatement) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean addUser(String name, String email, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modifyPasswordByEmail(String email, String password) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public int updateUserState(User user) {
		return userDao.updateUserState(user);
	}
	@Override
	public List<User> queryUserByFuzzyName(String uname) {
		return userDao.queryUserByFuzzyName(uname);
	}
	
}
