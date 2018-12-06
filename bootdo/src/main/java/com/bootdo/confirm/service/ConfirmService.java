package com.bootdo.confirm.service;

import com.bootdo.confirm.domain.ConfirmDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-22 18:07:01
 */
public interface ConfirmService {
	
	ConfirmDO get(String username);
	
	List<ConfirmDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ConfirmDO confirm);
	
	int update(ConfirmDO confirm);
	
	int remove(String username);
	
	int batchRemove(String[] usernames);
}
