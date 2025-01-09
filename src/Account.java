import java.util.Scanner;

public class Account {
    private static int numberOfAccounts = 1000;
    private double accountBalance;
    private final int accountNumber;

    public Account(double accountBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = numberOfAccounts++;
    }

    //User deposit class

    public void Deposit() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter deposit amount: ");
        double depositAmount = scnr.nextDouble();
        accountBalance += depositAmount;
        System.out.println("Amount deposited: " + depositAmount + "\nUpdated Balance: " + accountBalance);
    }

    //withdrawal class
    public void Withdraw() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter withdrawal amount: ");
        double withdrawalAmount = scnr.nextDouble();
        if ( withdrawalAmount > accountBalance ) {
            System.out.println("Insufficient funds");;
        } else{
            accountBalance -= withdrawalAmount;
            System.out.println("Withdrawn Amount: " + withdrawalAmount + "\n Updated Balance: " + accountBalance);;
        }
    }

    //used to return the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    //returns current account balance
    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {

        return "Account Number: " + accountNumber + "\n " + "Account Balance: " + accountBalance;
    }


}
