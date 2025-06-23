package lk.ijse.edu;

import lk.ijse.edu.bean.SpringBeanOne;
import lk.ijse.edu.bean.SpringBeanTwo;
import lk.ijse.edu.config.AppConfig1;
import lk.ijse.edu.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig1.class);
        context.refresh();

        //Configuration class 1
        SpringBeanOne bean1 = context.getBean(SpringBeanOne.class);
        SpringBeanOne bean2 = context.getBean(SpringBeanOne.class);
        System.out.println(bean1);
        System.out.println(bean2);
        //Configuration class 2
        SpringBeanTwo bean3 = context.getBean(SpringBeanTwo.class);
        SpringBeanTwo bean4 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean3);
        System.out.println(bean4);

        context.registerShutdownHook();
    }
}