package com.inker.common.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 测试类
 * @author inker
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
public class TestController {
	

	@RequestMapping("/admin/{city}/kongxu")
	public String index(@PathVariable("city") String id) {
		System.out.println(id);
		return  "success";
	}
	
	
	
}
