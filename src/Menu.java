import java.util.Scanner;

public class Menu {
    Scanner scnr = new Scanner(System.in);
    Bank bank = new Bank();


    /* Prints out a list of options which includes a part to access account, open a new account,
    close all accounts, and exit or stop code.  */
    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("*".repeat(12) + " MENU " + "*".repeat(12));
            System.out.println("Please make a selection: ");
            System.out.print("1) Access Account\n" +
                    "2) Open a New Account\n" +
                    "3) Close All Accounts\n" +
                    "4) Exit\n" +
                    ">>");

            int choiceA = scnr.nextInt();
            switch (choiceA) {
                case 1:
                    accessAccount();
                    break;
                case 2:
                    newAccount();
                    break;
                case 3:
                    closeAllAccount();
                    break;
                case 4:
                    System.out.println("Thank you for using BSU Banking App Goodbye. Exiting....");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choiceA");
            }
        }
    }

    /* Accesses the account by using the users pin, and also includes a Make deposit, Make withdrawals, see account balance,
    close account, and exit the method */
    private void accessAccount() {
        System.out.print("Enter Account PIN: ");
        int pin = scnr.nextInt();
        Customer customerPin = bank.getCustomerPin(pin);

        if (customerPin == null) {
            System.out.println("PIN is not valid");
            return;
        }

        System.out.println("Customer's Accounts:");
        for (Account acc : customerPin.getAccountsList()) {
            System.out.println(acc);
        }

        System.out.println("Enter Account Number: ");
        int accountNumber = scnr.nextInt();


        Account account = customerPin.getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Number Invalid");
            return;
        }

        boolean running = true;
        while (running){
            System.out.println("Please make a selection: ");
            System.out.println("1) Make a Deposit\n" +
                    "2) Make a withdrawal\n" +
                    "3) See account Balance\n" +
                    "4) Close account\n" +
                    "5) Exit\n" +
                    ">>");
            int choiceB = scnr.nextInt();

            switch (choiceB) {
                case 1:
                    account.Deposit();
                    break;
                case 2:
                    account.Withdraw();
                    break;
                case 3:
                    System.out.println("Account Balance: " + account.getAccountBalance());
                    break;
                case 4:
                    closeAccount();
                    break;
                case 5:
                    System.out.println("Exiting menu");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }


    // Checks if the user is a new customer, stores the user pin and also stores the deposit amount for new accounts
    private void newAccount() {
        System.out.println("Are you a new Customer: ");
        System.out.print("1) Yes\n" +
                "2) No\n");
        int choice2 = scnr.nextInt();

        if (choice2 == 1) {
            createNewCustomer();
        } else if (choice2 == 2) {
            System.out.println("Enter Account PIN: ");
            int userPin = scnr.nextInt();

            Customer customer = bank.getCustomerPin(userPin);
            if (customer == null) {
                System.out.println("Customer not found");
                return;
            }

            System.out.println("Enter deposit amount for new account: ");
            double depositAmount = scnr.nextDouble();
            Account newAccount = new Account(depositAmount);

            customer.addAccount(newAccount);
            System.out.println("New Account :  " + newAccount.getAccountNumber());
        }
    }


    //creates a new account by getting the users first and last name, pin, and deposit amount.
    private void createNewCustomer(){
        System.out.println("Please enter first name: ");
        String firstName = scnr.next();

        System.out.println("Please enter last name: ");
        String lastName = scnr.next();

        System.out.println("Please enter a 4 digit PIN: ");
        int userPin = scnr.nextInt();

        System.out.println("Please enter deposit amount: ");
        double depositAmount = scnr.nextDouble();

        Account newAccount = new Account(depositAmount);
        Customer customer = new Customer(firstName, lastName, userPin);

        customer.addAccount(newAccount);
        System.out.println("New Account :  " + newAccount.getAccountNumber());

        bank.addCustomer(customer);
    }

    //uses the users pin and account number to close or remove an account.
    private void closeAccount(){
        System.out.print("Enter Customer PIN: ");
        int userPin = scnr.nextInt();

        Customer customer = bank.getCustomerPin(userPin);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter the Account Number to close: ");
        int accountNumber = scnr.nextInt();

        Account accountToRemove = customer.getAccount(accountNumber);
        if (accountToRemove != null) {
            customer.removeAccount(accountToRemove);
            System.out.println("Account " + accountNumber + " removed successfully.");
        } else {
            System.out.println("Account number invalid.");
        }

    }


    //uses the users pin and account number to close or remove all accounts stored.
    private void closeAllAccount(){
        System.out.println("Enter Account PIN: ");
        int userPin = scnr.nextInt();

        Customer customer = bank.getCustomerPin(userPin);

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        bank.removeCustomer(customer);
        System.out.println("Account closed");

    }

}
