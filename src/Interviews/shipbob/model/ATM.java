package Interviews.shipbob.model;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> denominations;
    public ATM(){
        denominations = new HashMap<>();
        denominations.put(100, 250);
        denominations.put(200, 250);
        denominations.put(500, 250);
    }


    //Algo to find out notes for given amount
    public Map<Integer, Integer> getListOfValues(double amount){
        //return Map<Integer, Integer>
        return this.denominations;
    }

    public Map<Integer, Integer> getDenominations(){
        return this.denominations;
    }
}
