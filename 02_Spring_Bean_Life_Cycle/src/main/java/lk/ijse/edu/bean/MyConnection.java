package lk.ijse.edu.bean;

import org.springframework.beans.factory.DisposableBean;

public class MyConnection implements DisposableBean {
    public MyConnection() {
        System.out.println("MyConnection Constructor called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection destroy method called");
    }
}
