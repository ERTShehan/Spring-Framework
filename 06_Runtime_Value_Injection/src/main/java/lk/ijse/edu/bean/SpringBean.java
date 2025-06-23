package lk.ijse.edu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {
//    public SpringBean() {}
    @Autowired(required = false)
    public SpringBean(@Value("shehan") String name) {
        System.out.println("SpringBean Constructor: " + name);
//        System.out.println("SpringBean Constructor: " + number);
//        System.out.println("SpringBean Constructor: " + b);
    }

    @Autowired(required = false)
    public SpringBean(@Value("udara") String name, @Value("2025") int number) {
        System.out.println("SpringBean Constructor: " + name);
        System.out.println("SpringBean Constructor: " + number);
    }
}
