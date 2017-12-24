package service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.SessionDao;
import service.SessionService;
import entity.Session;


/**
 * @author lwy
 *
 */
@Service
public class SessionServiceImpl implements SessionService {
	private SessionDao sessionDao;
	public SessionDao getSessionDao() {
		return sessionDao;
	}
	@Resource
	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}

	@Override
	public boolean deleteSession(List<Integer> sid) {
		return sessionDao.deleteSession(sid)>0;
	}

	@Override
	public List<Session> queryAllSessionByProfile(String sprofile) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<String> queryAllProfile() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int querySessionID(String sname) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List<Session> searchSession(String searchText) {
		// TODO 自动生成的方法存根
		return null;
	}


	

	@Override
	public List<Map<String, Object>> queryAllSessionByMaster(String userid) {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public List<Session> queryAllSession() {
		return sessionDao.queryAllSession();
	}
	@Override
	public List<Session> querySessionByName(String sname) {
		return sessionDao.querySessionByName("%"+sname+"%");
	}
	@Override
	public List<Session> querySessionByProfile(String sprofile) {
		return sessionDao.querySessionByProfile("%"+sprofile+"%");
	}
	@Override
	public List<Session> querySessionByMasterid(String smasterid) {
		int master = Integer.parseInt(smasterid);
		return sessionDao.querySessionByMasterid(master);
	}
	

}
