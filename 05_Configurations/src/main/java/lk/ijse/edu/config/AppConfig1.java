package lk.ijse.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfig2.class})
@ComponentScan(basePackages = "lk.ijse.edu.bean")
public class AppConfig1 {

}
