package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeProjectApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(PracticeProjectApplication.class, args);
		PracticeClass practiceClass = ctx.getBean("m", PracticeClass.class);
		System.out.println(practiceClass.sayHello());
	}

}
