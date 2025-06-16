package lk.ijse.edu.bean;

import org.springframework.stereotype.Component;

@Component
public class Girl {
    public Girl() {
        System.out.println("Girl Constructor");
    }

    public void chat() {
        System.out.println("Chatting..");
    }
}
