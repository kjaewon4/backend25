package com.bu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
		(exclude = SpringApplicationAdminJmxAutoConfiguration.class)

//@ComponentScan(basePackages = "com.bu.backend")
public class BackEnd25Application {

	public static Map<String, String> db_list = new HashMap<>();

	public static void main(String[] args) {

		db_list.put("이충인", "1111");
		db_list.put("장한우", "2222");
		db_list.put("이충인 옆에", "3333");

		SpringApplication.run(BackEnd25Application.class, args);

	}

}
