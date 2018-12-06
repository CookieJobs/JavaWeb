package com.bootdo.order.service;

import com.bootdo.order.domain.SubmissionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author V0W&ssc
 * @email 1992lcg@163.com
 * @date 2018-11-15 16:02:46
 */
public interface SubmissionService {
	
	SubmissionDO get(String 客户编号);
	
	List<SubmissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubmissionDO submission);
	
	int update(SubmissionDO submission);
	
	int remove(String 客户编号);
	
	int batchRemove(String[] 客户编号s);
	
	int checkok(String 客户编号);
}
