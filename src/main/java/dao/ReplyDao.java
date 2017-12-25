package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Reply;

/**
 * 跟帖的数据库处理操作的接口
 * @author lwy
 *
 */
public interface ReplyDao {
	/**
	 * 批量删除reply
	 * @param rids
	 * @return
	 */
	int deleteReply(List<Integer> rids);
	

	/**
	 * 查询所有
	 * @return
	 */
	@Select("select * from reply")
	List<Reply> queryReplyAll();

	/**
	 * 模糊查询，条件content
	 * @param info
	 * @return
	 */
	@Select("select * from reply where rcontent like #{_parameter}")
	List<Reply> queryReplyByContent(String info);

	/**
	 * 查询总回复数
	 * @return
	 */
	@Select("select count(*) from reply")
	int queryReplyCount();
}