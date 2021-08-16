package com.inker.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inker.common.socket.WebSocket;

@Controller
public class IndexController {
	@Autowired
	WebSocket webSocket;
	
	  @GetMapping("/sendAllWebSocket")
	    public String test() {    
	    	String text="你们好！这是websocket群体发送！";
	        webSocket.sendAllMessage(text);
	        return text;        
	    }
	    
	  	@ResponseBody
	    @GetMapping("/sendOneWebSocket/{userName}")
	    public String sendOneWebSocket(@PathVariable("userName") String userName) {
	    	System.out.println("service--login-send --message--:"+userName);
	    	String text=userName+" 你好！ 这是websocket单人发送！";
	        webSocket.sendOneMessage(userName,text);
	        return text;
	    }
	  	
	  	@ResponseBody
	  	@RequestMapping("/index")
	  	public String index() {
	  		return "success";
	  	}
	
	
}
