package Interviews.shipbob.model.service;

import Interviews.shipbob.model.ATM;
import Interviews.shipbob.model.Bank;
import Interviews.shipbob.model.User;

import java.util.List;
import java.util.Scanner;

public class DriverApplication {

    private Bank bank;
    private ATM atmObject;
    public DriverApplication(){
        bank = new Bank();
        atmObject = new ATM();
    }

    private void doWithdrawl(int accountNo, double amt){
        final List<User> users = bank.getUsers();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            /*if(user.getAccountNo() == accountNo){
                if(user.getAmount() > amt){
                    double balance = user.getAmount() - amt;

//                    updateBalanceInUser();
                }else{

                }
            }*/
        }

    }

    private boolean isUserAuthenticated(int accountNo){
        int[] accounts = this.bank.getAccounts();
        for(int i=0;i<accounts.length;i++){
            if(accounts[i] == accountNo){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DriverApplication driverApplication = new DriverApplication();
        System.out.println("Please enter the account number");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int account = Integer.parseInt(scanner.nextLine());
            if(driverApplication.isUserAuthenticated(account)){
                System.out.println("Please select the options. 1. Withdraw 2. View Account balance");
                int option = Integer.parseInt(scanner.nextLine());
//                switch (option):


            }else {
                System.out.println("Invalid account number");
            }
        }

    }
}
