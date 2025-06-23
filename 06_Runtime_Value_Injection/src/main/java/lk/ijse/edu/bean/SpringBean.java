package lk.ijse.edu.bean;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    public SpringBean() {}
    public SpringBean(String name) {
        System.out.println("SpringBean Constructor");
    }
}
