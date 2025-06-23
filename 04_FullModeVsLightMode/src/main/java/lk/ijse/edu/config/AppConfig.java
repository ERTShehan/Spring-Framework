package lk.ijse.edu.config;

import lk.ijse.edu.bean.SpringBeanOne;
import lk.ijse.edu.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.edu.bean")
public class AppConfig {
    @Bean
    public SpringBeanOne springBeanOne() {
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo springBeanTwo() {
        return new SpringBeanTwo();
    }
}
