package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import entity.SensitiveWord;

public interface SensitiveWordDao {
	@Select("select * from sensitive_word")
	List<SensitiveWord> findAll();
	/**
	 * 批量插入数据
	 * @param words 敏感词集合
	 */
	int batchAdd(List<String> words);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	int batchDelete(List<Integer> ids);
	
	/**
	 * 模糊查询敏感词
	 * @return
	 */
	List<SensitiveWord> querySensitiveWord(String word);
	/**
	 *新增敏感词
	 * @param word
	 * @return
	 */
	@Insert("insert into sensitive_word(word) values(#{word})")
	int addSensitiveWord(SensitiveWord word);
}
