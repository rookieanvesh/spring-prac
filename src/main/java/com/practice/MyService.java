package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
//similarly we can use @PropertySources which contains tables of @PropertySource of all the different files and their class paths
public class MyService {
    private Environment environment;

    @Autowired
    //we can interact with the cmd line and environment properties using the environment bean and we can also access our application properties as well
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    //here we are looking at how to inject custom property here using the below method
    public String getCustomProperty() {
        return customProperty;
    }

    @Value("${my.prop}")
    private String customProperty;


    public String readProp() { //get the property from and read
        return environment.getProperty("my.custom.property");
    }

    //using field injection
    /*@Autowired
    @Qualifier("practiceClass2")*/
    private PracticeClass practiceClass;


/*
    @Autowired //whenever spring sees this autowired it will inject the necessary dependencies to this class
    public void injectDependencies(//method level injection
                                   @Qualifier("practiceClass2") PracticeClass practiceClass
    ) {
        this.practiceClass = practiceClass;
    }
*/

    @Autowired //setter injection
    public void setPracticeClass(@Qualifier("practiceClass2") PracticeClass practiceClass) {
        this.practiceClass = practiceClass;
    }


    /*
    we no longer need the autowired notation as whenever spring starts creating the MyService
    bean ,and it sees that the constructor for this class has an object parameter of PracticeClass
    as we have declared practiceClass above, it will automatically inject the needed dependencies
    @Autowired this is constructor injection and if use @Autowired on the declared variable it will be field injection
        private MyService( PracticeClass practiceClass) {
            this.practiceClass = practiceClass;
        }
    */

    public String aStory() {
        return "a story" + practiceClass.sayHello();
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String getPropertyFromAnotherFile() {
        return propertyFromAnotherFile;
    }

    @Value("${my.prop}")
    public String propertyFromAnotherFile;

    //constructor for this MyService which is injecting bean1 which is available for some certain profile
    public MyService (@Qualifier("bean1") PracticeClass practiceClass) {
        this.practiceClass = practiceClass;
    }

}
