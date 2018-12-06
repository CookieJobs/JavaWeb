package cn.edu.sdust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class TestController {
	
	@RequestMapping(method=RequestMethod.GET)
//	public String hello(){
//		return "hello";
//	}
//	@RequestMapping("h1")
	public String hello1(ModelMap model){
		model.addAttribute("message","hello, welcome !");
		return "hello1";
	}
}
