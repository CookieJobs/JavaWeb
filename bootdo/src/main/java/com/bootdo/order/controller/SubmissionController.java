package com.bootdo.order.controller;

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

import com.bootdo.order.domain.SubmissionDO;
import com.bootdo.order.service.SubmissionService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author V0W&ssc
 * @email 1992lcg@163.com
 * @date 2018-11-15 16:02:46
 */
 
@Controller
@RequestMapping("/order/submission")
public class SubmissionController {
	@Autowired
	private SubmissionService submissionService;
	
	@GetMapping()
	@RequiresPermissions("order:submission:submission")
	String Submission(){
	    return "order/submission/submission";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:submission:submission")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubmissionDO> submissionList = submissionService.list(query);
		int total = submissionService.count(query);
		PageUtils pageUtils = new PageUtils(submissionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:submission:add")
	String add(){
	    return "order/submission/add";
	}

	@GetMapping("/edit/{客户编号}")
	@RequiresPermissions("order:submission:edit")
	String edit(@PathVariable("客户编号") String 客户编号,Model model){
		SubmissionDO submission = submissionService.get(客户编号);
		model.addAttribute("submission", submission);
	    return "order/submission/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:submission:add")
	public R save( SubmissionDO submission){
		if(submissionService.save(submission)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:submission:edit")
	public R update( SubmissionDO submission){
		submissionService.update(submission);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:submission:remove")
	public R remove( String 客户编号){
		if(submissionService.remove(客户编号)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:submission:batchRemove")
	public R remove(@RequestParam("ids[]") String[] 客户编号s){
		submissionService.batchRemove(客户编号s);
		return R.ok();
	}
	
	/**
	 * check OK 
	 */
	@PostMapping( "/checkok")
	@ResponseBody
	@RequiresPermissions("order:submission:checkok")
	public R checkok(String 客户编号){
		SubmissionDO smd = submissionService.get(客户编号);
		Integer cnt = smd.get消费次数();
		if (cnt > 0) {
			cnt -= 1;
		}else{
			return R.error();
		}
		smd.set消费次数(cnt);
		if(submissionService.update(smd)>0)
			return R.ok();
		return R.error();
//		if(submissionService.checkok(客户编号)>0){
//			return R.ok();
//		}
//		return R.error();
	}
	
}
