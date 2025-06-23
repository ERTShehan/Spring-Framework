package lk.ijse.edu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {
//    public SpringBean() {}
    public SpringBean(@Value("udara") String name) {
        System.out.println("SpringBean Constructor");
    }
}
