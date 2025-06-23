package lk.ijse.edu.config;

import lk.ijse.edu.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfig1.class, AppConfig2.class})
@ComponentScan(basePackages = "lk.ijse.edu.bean")
public class AppConfig {
    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }
}
