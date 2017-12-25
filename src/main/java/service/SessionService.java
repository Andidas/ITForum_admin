package service;

import java.util.List;

import entity.Session;

/**
 * @author 刘伟艺
 * session版块接口
 */
public interface SessionService {
	/**
	 * 删除session
	 * @param sid 
	 * @return
	 */
	boolean deleteSession(List<Integer> sid);
	/**
	 * 查询所有session
	 * @return
	 */
	List<Session> queryAllSession();
	/**
	 * 查询所有session,模糊查询，条件sname
	 * @param sname
	 * @return
	 */
	List<Session> querySessionByName(String sname);
	/**
	 * 查询所有session,模糊查询，条件sprofile
	 * @param sname
	 * @return
	 */
	List<Session> querySessionByProfile(String sprofile);
	/**
	 * 查询所有session,精确查询，条件smasterid
	 * @param sname
	 * @return
	 */
	List<Session> querySessionByMasterid(String smasterid);
	/**
	 * 得到总版块数
	 * @return
	 */
	int querySessionCount();
	
	
	
}		
 