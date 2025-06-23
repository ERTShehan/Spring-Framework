package lk.ijse.edu.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class SpringBean implements InitializingBean {
    @Value("${os.name}")
    private String osName;

    @Value("${user.name}")
    private String LOGNAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
        System.out.println(LOGNAME);
    }
}
