package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Session;
/**
 * 版块的数据库处理操作的接口
 * @author lwy
 *
 */
public interface SessionDao {


	
	/**
	 * 通过搜索栏查找session
	 * @param searchText
	 * @return
	 */
	@Select("select * from session where sname like CONCAT(CONCAT('%', #{_parameter}), '%')")
	List<Session> searchSession(String searchText);
	

	@Update("update `session` set sname=#{sname},sprofile=#{sprofile},sstatement=#{sstatement},spicture=#{spicture} where sid = #{sid}")
	int updateSession(Session session);
	/**
	 * 查询所有session
	 * @return
	 */
	@Select("select * from `session`")
	List<Session> queryAllSession();
	/**
	 * 查询所有session,模糊查询，条件sname
	 * @param sname
	 * @return
	 */
	@Select("select * from `session` where sname like #{sname}")
	List<Session> querySessionByName(String sname);
	/**
	 * 删除session
	 * 触发器如下：
	 * DROP TRIGGER IF EXISTS t_afterdelete_on_session;
	 * CREATE TRIGGER t_afterdelete_on_session
	 * BEFORE DELETE ON `session`
	 * FOR EACH ROW
	 * BEGIN
     * 		delete from topic where tsid=old.sid;
	 *		delete from follow where sid=old.sid;
	 * END;
	 * @param sid
	 * @return
	 */
	int deleteSession(List<Integer> sid);
	
	/**
	 * 查询所有session,准确查询，条件smasterid
	 * @param sname
	 * @return
	 */
	@Select("select * from `session` where smasterid = #{_parameter}")
	List<Session> querySessionByMasterid(int smasterid);
	
	/**
	 * 查询所有session,模糊查询，条件sprofile
	 * @param sname
	 * @return
	 */
	@Select("select * from `session` where sprofile like #{_parameter}")
	List<Session> querySessionByProfile(String sprofile);

	/**
	 * 查询总版块数
	 * @return
	 */
	@Select("select count(*) from `session`")
	int querySessionCount();
}
