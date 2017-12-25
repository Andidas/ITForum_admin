package service;

import java.util.List;

import entity.Reply;



public interface ReplyService {

	/**
	 * 查询所有
	 * @return
	 */
	List<Reply> queryReplyAll();

	
	/**
	 * 模糊查询内容
	 * @param info
	 * @return
	 */
	List<Reply> queryReplyByContent(String info);


	/**
	 * 批量删除reoly
	 * @param rids
	 * @return
	 */
	boolean deleteReply(List<Integer> rids);
	

	
}