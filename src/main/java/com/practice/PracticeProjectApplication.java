package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeProjectApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(PracticeProjectApplication.class, args);
		MyService myService = ctx.getBean(MyService.class);
		System.out.println(myService.aStory());
	}

}
