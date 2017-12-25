package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.SensitiveWordService;
import dao.SensitiveWordDao;
import entity.SensitiveWord;

@Service
public class SensitiveWordServiceImpl implements SensitiveWordService {
	private SensitiveWordDao sensitiveWordDao ;

	public SensitiveWordDao getSensitiveWordDao() {
		return sensitiveWordDao;
	}
	@Resource
	public void setSensitiveWordDao(SensitiveWordDao sensitiveWordDao) {
		this.sensitiveWordDao = sensitiveWordDao;
	}

	@Override
	public List<SensitiveWord> findAll() {
		return sensitiveWordDao.findAll();
	}

	@Override
	public boolean batchAdd(List<String> words) {
		return sensitiveWordDao.batchAdd(words)>0;
	}

	@Override
	public boolean batchDelete(List<Integer> ids) {
		return sensitiveWordDao.batchDelete(ids)>0;
	}
	@Override
	public List<SensitiveWord> querySensitiveWord(String word) {
		return sensitiveWordDao.querySensitiveWord(word);
	}
	@Override
	public boolean addSensitiveWord(SensitiveWord word) {
		return sensitiveWordDao.addSensitiveWord(word)>0;
	}


}
