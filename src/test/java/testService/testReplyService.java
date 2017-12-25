package testService;

import javax.annotation.Resource;

import org.junit.Test;

import service.ReplyService;
import test.BaseJUnit4Test;

public class testReplyService extends BaseJUnit4Test {
	private ReplyService replyService;
	
	public ReplyService getReplyService() {
		return replyService;
	}
	@Resource
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Test
	public void queryReplyByContent() {
		System.out.println(replyService.queryReplyByContent("来"));
	}

}
