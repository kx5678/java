package com.inker.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.baidu.ueditor.ActionEnter;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/config")
    public String config(String action,HttpServletRequest request,HttpServletResponse response) {
        return "redirect:/static/editor/jsp/config.json";
    }
	
	
		@ResponseBody
	   @PostMapping("/file/upload")
	    public String upload(MultipartHttpServletRequest multipartHttpServletRequest){
			MultipartFile file = multipartHttpServletRequest.getFile("file");
		   JSONObject json = new JSONObject();
	        String url="https://boss.kanwu.cn/imgs/kanwu/20181218/1545111726513.jpg";
	        String msg="";
	        try {
	        	msg=  file.getOriginalFilename();
	        } catch (Exception e) {
	          
	        }
	        
	        json.put("code", 1);
	        json.put("state", true);
	        json.put("url", url);
	        json.put("msg", msg);
	        
	        System.out.println(json.toString());
	        return json.toString();
	    }

}
