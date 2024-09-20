package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
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
    @Bean
    @Primary //gives this bean the topmost priority
    public PracticeClass practiceClass3(){
        return new PracticeClass("third bean");
    }
}
