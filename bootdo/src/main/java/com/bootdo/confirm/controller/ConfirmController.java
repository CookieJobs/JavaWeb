package com.bootdo.confirm.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.confirm.domain.ConfirmDO;
import com.bootdo.confirm.service.ConfirmService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-22 18:07:01
 */
 
@Controller
@RequestMapping("/confirm/confirm")
public class ConfirmController {
	@Autowired
	private ConfirmService confirmService;
	
	@GetMapping()
	@RequiresPermissions("confirm:confirm:confirm")
	String Confirm(){
	    return "confirm/confirm/confirm";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("confirm:confirm:confirm")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ConfirmDO> confirmList = confirmService.list(query);
		int total = confirmService.count(query);
		PageUtils pageUtils = new PageUtils(confirmList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("confirm:confirm:add")
	String add(){
	    return "confirm/confirm/add";
	}

	@GetMapping("/edit/{username}")
	@RequiresPermissions("confirm:confirm:edit")
	String edit(@PathVariable("username") String username,Model model){
		ConfirmDO confirm = confirmService.get(username);
		model.addAttribute("confirm", confirm);
	    return "confirm/confirm/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("confirm:confirm:add")
	public R save( ConfirmDO confirm){
		if(confirmService.save(confirm)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("confirm:confirm:edit")
	public R update( ConfirmDO confirm){
		confirmService.update(confirm);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("confirm:confirm:remove")
	public R remove( String username){
		if(confirmService.remove(username)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("confirm:confirm:batchRemove")
	public R remove(@RequestParam("ids[]") String[] usernames){
		confirmService.batchRemove(usernames);
		return R.ok();
	}
	
	@PostMapping( "/check")
	@ResponseBody
	@RequiresPermissions("confirm:confirm:check")
	public R check(String username){
		ConfirmDO confirmDO = confirmService.get(username);
		if (confirmDO.getReadyConfirm1() == 1) {
			confirmDO.setReadyConfirm1(0);
		}else{
			confirmDO.setReadyConfirm1(1);
		}
		confirmService.update(confirmDO);
		return R.ok();
	}
	
}
