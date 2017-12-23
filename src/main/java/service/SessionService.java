package service;

import java.util.List;
import java.util.Map;

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
	 * 查询属于同一类的session
	 * @param sprofile
	 * @return
	 */
	List<Session>queryAllSessionByProfile(String sprofile);
	/**
	 * 查询所有的session分类profile
	 * @return
	 */
	List<String> queryAllProfile();
	/**
	 * 查找session
	 * @param sname
	 * @return
	 */
	int querySessionID(String sname);
	
	/**
	 * 通过搜索栏查询到的内容
	 * @param searchText
	 * @return
	 */
	List<Session> searchSession(String searchText);
	

	
	
	
	/**
	 * 通过用户id查询该用户创建的session
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> queryAllSessionByMaster(String userid);
	
	
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
	
	
}		
 