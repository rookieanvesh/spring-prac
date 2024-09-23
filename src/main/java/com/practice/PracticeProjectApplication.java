package com.practice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;
@SpringBootApplication
public class PracticeProjectApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(PracticeProjectApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));//the test profile is active here so the bean marked with test profile only should be injected

		var ctx = app.run(args);
		MyService myService = ctx.getBean(MyService.class);
		System.out.println(myService.aStory());
		System.out.println(myService.getJavaVersion());
		System.out.println(myService.getOsName());
		System.out.println(myService.readProp());
		System.out.println(myService.getPropertyFromAnotherFile());
		System.out.println(myService.getCustomProperty());
	}
}
