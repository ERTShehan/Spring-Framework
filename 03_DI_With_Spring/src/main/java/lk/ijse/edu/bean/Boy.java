package lk.ijse.edu.bean;

public class Boy {
    //Property injection
//    Girl girl = new Girl();
//
//    public void chatWithGirl() {
//        girl.chat();
//    }

    //Constructor through dependency injection
//    Girl girl;
//
//    public Boy(Girl girl) {
//        this.girl = girl;
//    }
//
//    public void chatWithGirl() {
//        Boy boy = new Boy(new Girl());
//        boy.chat();
//    }

    //Setter method through dependency injection
    Girl girl;

    public void setterMethod(Girl girl) {
        this.girl = girl;
    }

    public void chatWithGirl() {
        Boy boy = new Boy();
        boy.setterMethod(new Girl());
        boy.girl.chat();
    }
}
