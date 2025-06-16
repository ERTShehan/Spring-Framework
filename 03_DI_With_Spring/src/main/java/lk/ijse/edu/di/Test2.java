package lk.ijse.edu.di;

import org.springframework.stereotype.Component;

@Component
public class Test2 {
    DI test1 = new Test1();

    public Test2() {
        System.out.println("Test2 Constructor");
    }

    public void calledHelloMethod() {
        test1.sayHello();
    }
}
