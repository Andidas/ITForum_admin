package service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.SessionService;
import dao.SessionDao;
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
	@Override
	public int querySessionCount() {
		return sessionDao.querySessionCount();
	}
	

}
