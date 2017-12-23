package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.PrivateLetterService;
import utils.ConstantsData;
import dao.PrivateLetterDao;
import dao.UserDao;
import entity.PrivateLetter;
import entity.User;

@Service
public class PrivateLetterServiceImpl implements PrivateLetterService {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	private PrivateLetterDao privateLetterDao;
	
	
	public PrivateLetterDao getPrivateLetterDao() {
		return privateLetterDao;
	}
	@Resource
	public void setPrivateLetterDao(PrivateLetterDao privateLetterDao) {
		this.privateLetterDao = privateLetterDao;
	}

	@Override
	public boolean updateAllReaded(String uid) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean evenReaded(String user_id, String friend_id) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public List<PrivateLetter> findAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean batchDelete(String ids) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean batchAdd(String puid, String ptouid, int type,
			String pcontent) {
		if(puid.equals(ptouid))return false;
		List<PrivateLetter> letters = new ArrayList<PrivateLetter>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		int uid = Integer.parseInt(puid);
		int touid = Integer.parseInt(ptouid);
		
		letters.add(new PrivateLetter(uid,touid,uid,touid,type,time,pcontent));
		letters.add(new PrivateLetter(touid,uid,uid,touid,type,time,pcontent));
			
		return privateLetterDao.batchAdd(letters)>0;
	}
	@Override
	public boolean sendSystemInfoToAllUser(String content){
		int admin_id = 37;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		List<PrivateLetter> letters = new ArrayList<PrivateLetter>();
		
		List<User> users = userDao.queryUserList();
		for (User user : users) {
			int id = user.getUid();
			letters.add(new PrivateLetter(id,admin_id,id,admin_id,ConstantsData.SYSTEM_MESSAGE,time,content));
			letters.add(new PrivateLetter(admin_id,id,id,admin_id,ConstantsData.SYSTEM_MESSAGE,time,content));
		}
		
		return privateLetterDao.batchAdd(letters)>0;
	}

	@Override
	public boolean deleteFriendsLetter(String uid, String fid) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public List<PrivateLetter> queryAllSystemMessage() {
		return privateLetterDao.queryAllSystemMessage();
	}
	@Override
	public List<PrivateLetter> queryAllFeedback() {
		return privateLetterDao.queryAllFeedback();
	}
	@Override
	public boolean markReaded(List<Integer> pids) {
		return privateLetterDao.markReaded(pids);
	}
	
	
	
}