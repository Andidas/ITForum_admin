package service;

import java.util.List;

import entity.SensitiveWord;

public interface SensitiveWordService {
	List<SensitiveWord> findAll();
	/**
	 * 批量插入数据
	 * @param words 敏感词集合
	 */
	boolean batchAdd(List<String> words);	
	/**
	 * 批量删除
	 * @param ids
	 */
	boolean batchDelete(List<Integer> ids);
	
	/**
	 * 模糊查询敏感词
	 * @param word
	 * @return
	 */
	List<SensitiveWord> querySensitiveWord(String word);
	/**
	 * 新增敏感词
	 * @param word
	 * @return
	 */
	boolean addSensitiveWord(SensitiveWord word);
	
}
