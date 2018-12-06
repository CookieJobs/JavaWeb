package com.bootdo.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.order.dao.SubmissionDao;
import com.bootdo.order.domain.SubmissionDO;
import com.bootdo.order.service.SubmissionService;



@Service
public class SubmissionServiceImpl implements SubmissionService {
	@Autowired
	private SubmissionDao submissionDao;
	
	@Override
	public SubmissionDO get(String 客户编号){
		return submissionDao.get(客户编号);
	}
	
	@Override
	public List<SubmissionDO> list(Map<String, Object> map){
		return submissionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return submissionDao.count(map);
	}
	
	@Override
	public int save(SubmissionDO submission){
		return submissionDao.save(submission);
	}
	
	@Override
	public int update(SubmissionDO submission){
		return submissionDao.update(submission);
	}
	
	@Override
	public int remove(String 客户编号){
		return submissionDao.remove(客户编号);
	}
	
	@Override
	public int batchRemove(String[] 客户编号s){
		return submissionDao.batchRemove(客户编号s);
	}

	@Override
	public int checkok(String 客户编号) {
		return submissionDao.checkok(客户编号);
	}
	
}
