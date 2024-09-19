package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    //this has a method bean of Practice Class which returns a new PracticeClass() object which is
    //marked as a bean and scanned by spring as this is annotated with @configuration which helps detects
    //classes which contains bean methods
    @Bean("m")
    public PracticeClass practiceClass(){
        return new PracticeClass();
    }
}
