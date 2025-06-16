package lk.ijse.edu.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 {
    @Autowired
    DI test1;

    public Test2() {
        System.out.println("Test2 Constructor");
    }

    public void calledHelloMethod() {
        test1.sayHello();
    }
}
