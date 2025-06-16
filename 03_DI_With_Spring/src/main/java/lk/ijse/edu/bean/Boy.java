package lk.ijse.edu.bean;

public class Boy {
    //Property injection
    Girl girl = new Girl();

    public void chatWithGirl() {
        girl.chat();
    }
}
