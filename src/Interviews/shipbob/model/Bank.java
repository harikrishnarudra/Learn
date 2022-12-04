package Interviews.shipbob.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public int[] getAccounts(){
        return new int[]{1234567812, 1234567813};
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("userId1", 1234567812, 1000.0));
        users.add(new User("userId2", 1234567813, 2000.0));
        return users;
    }

}
