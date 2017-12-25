package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.ReplyService;
import dao.ReplyDao;
import entity.Reply;
@Service
public class ReplyServiceImpl implements ReplyService {
	private ReplyDao replyDao;
	
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	@Resource
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<Reply> queryReplyAll() {
		return replyDao.queryReplyAll();
	}
	@Override
	public List<Reply> queryReplyByContent(String info) {
		return replyDao.queryReplyByContent("%"+info+"%");
	}
	@Override
	public boolean deleteReply(List<Integer> rids) {
		return replyDao.deleteReply(rids)>0;
	}
	@Override
	public int queryReplyCount() {
		return replyDao.queryReplyCount();
	}
	
	

	

}
