import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private int userPin;
    private final ArrayList<Account> accountsList = new ArrayList<>();

    public Customer(String firstName, String lastName, int userPin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPin = userPin;
    }

    public void addAccount(Account account) {
        accountsList.add(account);
    }

    public void removeAccount(Account account) {
        accountsList.remove(account);
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accountsList) {
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    //gets all the accounts in the account list
    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //returns User Pin
    public int getUserPin() {
        return userPin;
    }
    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n Pin: " + userPin;
    }




}
