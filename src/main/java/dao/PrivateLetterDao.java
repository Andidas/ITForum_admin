package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.PrivateLetter;

public interface PrivateLetterDao {
	
	/**
	 * 查询所有系统消息
	 * @param message_type
	 * @return
	 */
	@Select("select * from private_letter where message_type = 2 and user_id=37 and friend_id<>37")
	public List<PrivateLetter> queryAllSystemMessage();
	
	/**
	 * 得到所有反馈
	 * @return
	 */
	@Select("select * from private_letter where message_type = 3 and user_id = 37")
	public List<PrivateLetter> queryAllFeedback();
	
	
	/**
	 * 批量删除朋友私信
	 * @param ids
	 * @return
	 */
	void deleteFriendsLetter(Map<String,Object> ids);
	
	@Select("select * from private_letter")
	List<PrivateLetter> findAll();

	/**
	 * 私信状态设置为已读
	 * @param id
	 * @return
	 */
	@Update("update  private_letter set pstatus=2  where user_id = #{user_id} and friend_id = #{friend_id};")
	int evenReaded(Map<String,Object> id);
	
	/**
	 * 标记所有私信为已读
	 * @param uid
	 * @return
	 */
	@Update("update  private_letter set pstatus=2  where user_id = #{_parameter}")
	int updateAllReaded(int uid);
	/**
	 * 批量插入数据
	 * @param letters
	 */
	int batchAdd(List<PrivateLetter> letters);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void batchDelete(List<Integer> ids);
	
	
	
	/**
	 * 信息列表数据的条数
	 * @param id 用户id
	 * @return
	 */
	int queryMyPrivateLetterList_count(int id);

	/**
	 * 标记私信为已读
	 * @param pids
	 * @return
	 */
	boolean markReaded(List<Integer> pids);

	/**
	 * 查询未读的系统消息总数
	 * @return
	 */
	@Select("select count(*) from private_letter where message_type = 2 and user_id=37 and friend_id<>37")
	public int querySystemCount();

	/**
	 * 查询未读的系统消息总数
	 * @return
	 */
	@Select("select count(*) from private_letter where message_type = 3 and user_id = 37 and pstatus=1")
	public int queryFeedbackCount();



}