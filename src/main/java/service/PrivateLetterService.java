package service;

import java.util.List;

import entity.PrivateLetter;

/**
 * @author Administrator
 *
 */
public interface PrivateLetterService {
	
	/**
	 * 查询所有系统消息
	 * @return
	 */
	List<PrivateLetter> queryAllSystemMessage();
	
	/**
	 * 查询所有反馈
	 * @return
	 */
	List<PrivateLetter> queryAllFeedback();
	/**
	 * 标记所有私信为已读
	 * @param uid
	 * @return
	 */
	boolean updateAllReaded(String uid);
	/**
	 * 私信状态设置为已读
	 * @param 
	 * @return
	 */
	boolean evenReaded(String user_id,String friend_id);
	/**
	 * 分页查询我的私信列表详情
	 * @param param {
	 * 	user_id = *,自己id
	 * 	friend_id = *,好友id
	 * 	pageno = *,页数
	 * 	pagesize= * 每页条数}
	 * @return
	 */
///	PageMode<Map<String, Object>> queryMyPrivateLetterList_detail(
			//PageParam pageParam);
	/**
	 * 查询我的私信列表
	 * @param pageParam
	 * @return
	 */
//	PageMode<Map<String, Object>> queryMyPrivateLetterList(PageParam pageParam);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<PrivateLetter> findAll();
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	boolean batchDelete(String ids);
	/**
	 * 批量插入
	 * @param puid 发送者
	 * @param ptouid 接收者
	 * @param pcontent
	 * @return 成功返回true
	 */
	boolean batchAdd(String puid, String ptouid, int type, String pcontent);
	/**
	 * 批量删除friend的私信
	 * @param uid
	 * @param fid
	 * @return
	 */
	boolean deleteFriendsLetter(String uid, String fid);

	/**
	 * 私信状态设置为已读
	 * @param fids
	 * @return
	 */
	boolean markReaded(List<Integer> fids);

	/**
	 * 群发系统消息
	 * @param content
	 * @return
	 */
	boolean sendSystemInfoToAllUser(String content);


}
