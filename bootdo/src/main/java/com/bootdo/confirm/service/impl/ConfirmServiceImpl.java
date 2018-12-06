package com.bootdo.confirm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.confirm.dao.ConfirmDao;
import com.bootdo.confirm.domain.ConfirmDO;
import com.bootdo.confirm.service.ConfirmService;



@Service
public class ConfirmServiceImpl implements ConfirmService {
	@Autowired
	private ConfirmDao confirmDao;
	
	@Override
	public ConfirmDO get(String username){
		return confirmDao.get(username);
	}
	
	@Override
	public List<ConfirmDO> list(Map<String, Object> map){
		return confirmDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return confirmDao.count(map);
	}
	
	@Override
	public int save(ConfirmDO confirm){
		return confirmDao.save(confirm);
	}
	
	@Override
	public int update(ConfirmDO confirm){
		return confirmDao.update(confirm);
	}
	
	@Override
	public int remove(String username){
		return confirmDao.remove(username);
	}
	
	@Override
	public int batchRemove(String[] usernames){
		return confirmDao.batchRemove(usernames);
	}
	
}
