package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import entity.Topic;
/**
 * 
 * @author lwy
 *
 */
public interface TopicDao {
	/**
	 * 删除topic
	 * 触发器如下：
	 * Drop TRIGGER if EXISTS t_afterdelete_on_topic;
	 * create trigger t_afterdelete_on_topic
	 * before delete on topic
	 * for each ROW
	 * begin 
	 *			delete from reply where rtid = old.tid;
	 * end;
	 * @param tid
	 * @return
	 */
	int deleteTopics(List<Integer> tid);
	

	/**
	 * 模糊查询题目
	 * @param title
	 * @return
	 */
	List<Topic> queryTopicByTitle(String title);
	
	/**
	 * 模糊查询内容
	 * @param content
	 * @return
	 */
	List<Topic> queryTopicByContent(String content);

	/**
	 * 查询所有帖子
	 * @return
	 */
	@Select("select * from topic")
	List<Topic> queryTopicAll();
	
	/**
	 * 查询用户发表的所有帖子
	 * @param userid
	 * @return
	 */
	@Select("select * from topic where tuid = #{_parameter}")
	List<Topic> queryTopicByMaster(int userid);

	@Select("select * from topic where ttime >=#{_parameter}")
	List<Topic> queryTopicsRegisterByToday(String ttime);





	
	
	

}
