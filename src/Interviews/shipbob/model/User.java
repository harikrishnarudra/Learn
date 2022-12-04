package Interviews.shipbob.model;

import lombok.Getter;
import lombok.Setter;

public class User {

    //Pincode
    @Getter
    @Setter
    private String userId;
    //accountno
    @Getter
    @Setter
    private int accountNo;
    //balance
    @Getter
    @Setter
    private double amount;
    public User(String userId, int accountNo, double amount){
        this.userId = userId;
        this.accountNo = accountNo;
        this.amount = amount;
    }
}
