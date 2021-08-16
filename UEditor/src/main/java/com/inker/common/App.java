package com.inker.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类
 * @author inker
 *
 */
@SpringBootApplication
//@MapperScan("com.kanwu.common.mapper")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
