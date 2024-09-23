package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //@Configuration annotation is used to indicate that a class is a source of bean definitions
@Profile("dev")
public class ApplicationConfig {
    //this has a method bean of Practice Class which returns a new PracticeClass() object which is
    //marked as a bean and scanned by spring as this is annotated with @configuration which helps detects
    //classes which contains bean methods
    @Bean
    //@Qualifier("bean1") //we make use of qualifier to inject beans when we have multiple beans of the same type
    public PracticeClass practiceClass(){
        return new PracticeClass("first bean");
    }

    @Bean
    //@Qualifier("bean2")
    public PracticeClass practiceClass2(){
        return new PracticeClass("second bean");
    }
    @Bean("bean1")
    //@Profile("dev")//in this way we can make this bean available only for this dev environment
    //@Primary //gives this bean the topmost priority among all the beans of the same type
    public PracticeClass practiceClass3(){
        return new PracticeClass("dev bean");
    }
    @Bean
    public PracticeClass myFirstClass1(){
        return new PracticeClass("all bean");
    }

    @Bean("bean2")
   // @Profile("test")
    public PracticeClass myFirstClass2(){
        return new PracticeClass("test bean");
    }
}

/*ALL TO KNOW ABOUT CONFIGURATION
* Purpose: It marks a class as a configuration class, allowing you to define beans using
*  methods annotated with @Bean.
* These beans can then be used throughout your application.
Relationship with @ComponentScan: Often used in conjunction with @ComponentScan,
* which tells Spring to scan the specified packages for classes annotated with
*  @Component, @Service, @Repository, or @Controller. These classes are then automatically
*  registered as beans in the Spring application context.*/
