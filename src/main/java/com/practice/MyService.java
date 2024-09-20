package com.practice;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private PracticeClass practiceClass;

    //we no longer need the autowired notation as whenever spring starts creating the MyService
    //bean ,and it sees that the constructor for this class has an object parameter of PracticeClass
    //as we have declared practiceClass above, it will automatically inject the the needed dependencies
    //@Autowired this is constructor injection and if use @Autowired on the declared variable it will be field injection
    private MyService( PracticeClass practiceClass) {
        this.practiceClass = practiceClass;
    }

    public String aStory(){
        return "a story" + practiceClass.sayHello();
    }
}
