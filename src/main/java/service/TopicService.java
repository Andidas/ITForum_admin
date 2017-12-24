package service;

import java.util.List;

import entity.Topic;

/**
 * @author lwy
 * topic service 
 */
public interface TopicService {
	
	/**
	 * 删除topic
	 * @param tid
	 * @return
	 */
	boolean deleteTopic(List<Integer> tid);
	
	
	/**
	 * 模糊查询题目
	 * @param text
	 * @return
	 */
	List<Topic> queryTopicByTitle(String text);
	
	/**
	 * 模糊查询内容
	 * @param content
	 * @return
	 */
	List<Topic> queryTopicByContent(String content);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Topic> queryTopicAll();
		
	/**
	 * 查询用户发表的所有帖子
	 * @param userid
	 * @return
	 */
	List<Topic> queryTopicByMaster(String userid);


	/**
	 * 查询今天发布的帖子
	 * @return
	 */
	List<Topic> queryTopicsRegisterByToday();
	
}
