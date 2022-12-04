package Interviews.shipbob.model.account;


/**
 * Developing Automated teller machine for International State Bank
 * Develop a Console application depicting ATM Machine and its interaction with Bank and Bank’s Customer.
 * Implement ATM, Bank and Customer Accounts in a single application where user interaction will happen with the console application. This should be done considering the time available to solve the problem.
 *
 * Components
 * An ATM machine will have the following components.
 * Bank with which ATM machine is connected to. Bank will contain user account details and account pin codes. An ATM needs to connect with the Bank to authenticate the user. Bank will also contain information about the amount the user has with the bank.
 * The ATM machine will contain 3 buckets which can hold cash of nominations 100,200 and 500 having a maximum limit of 250 numbers of notes in each bucket.
 * For simplicity, user will enter account number instead of swiping card (or entering card number)
 * Each Account will have a pin code which is mandatory to transact amount for the account and Account balance
 *
 *
 * Initialize the ATM
 * As part of this step, the ATM needs to be initialized, and gets connected to the bank.
 * Bank needs to be initialized with a sample account (12 digit account number, PIN code and default balance) with details.
 * ATM needs to be initialized with 3 buckets having 50 denominations  already present in each bucket.
 *
 * Authenticating User
 * Ask a user to enter account details (12 digit number)
 * Validate account details with the bank
 * Once the user Logs in successfully, print a message to enter the amount to be withdrawn.
 * Until the user enters the correct account number, the User session should not start and the Console application will keep on asking to enter the account number.
 *
 * Allow User to withdraw cash from the ATM
 * Once a Bank customer’s account details gets validated, the option to Withdraw cash is provided.
 * User is asked to enter withdrawal amount
 * Once the user enters the amount, User is asked to enter a pin which gets validated with the bank along with the user's balance.
 * Write an algorithm to fulfill the user's entered amount with nominations present in the bucket.
 * If the amount can be fulfilled, display Cash withdrawal completed and deduct the amount from the User's balance.
 */

public class Account {
    private int accountNo;
    private AccountType account;
    private String userId;
    private double balance;

}
