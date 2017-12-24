package testService;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import service.TopicService;
import test.BaseJUnit4Test;

public class testTopicService extends BaseJUnit4Test{
	private TopicService topicService;
	

	public TopicService getTopicService() {
		return topicService;
	}

	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	@Test
	public void testDeleteTopic() {
		List<Integer> tid = new ArrayList<Integer>();
		tid.add(122);tid.add(125);
		assertTrue(topicService.deleteTopic(tid));
	}

	@Test
	public void testQueryTopicByTitle() {
		System.out.println(topicService.queryTopicByTitle("去"));
	}

	@Test
	public void testQueryTopicAll() {
		System.out.println(topicService.queryTopicAll());
	}
	
	@Test
	public void queryTopicByContent(){
		System.out.println(topicService.queryTopicByContent("看"));
	}

}
