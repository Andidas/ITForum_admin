package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.TopicService;
import dao.TopicDao;
import entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	private TopicDao topicDao ;
	
	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Resource
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Override
	public boolean deleteTopic(List<Integer> tid) {
		return topicDao.deleteTopics(tid)>0;
	}

	@Override
	public List<Topic> queryTopicByTitle(String text) {
		return topicDao.queryTopicByTitle(text);
	}
	@Override
	public List<Topic> queryTopicAll() {
		return topicDao.queryTopicAll();
	}
	@Override
	public List<Topic> queryTopicByContent(String content) {
		return topicDao.queryTopicByContent(content);
	}
	@Override
	public List<Topic> queryTopicByMaster(String userid) {
		int id = Integer.parseInt(userid);
		return topicDao.queryTopicByMaster(id);
	}

	
	
}
