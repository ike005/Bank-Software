# Bank-Software

# Bank Account Application

## Overview
This project implements a Bank Account application that allows customers to create new accounts, access existing ones, deposit or withdraw funds, and manage their accounts through a simple menu interface. It models a real-world banking system where customers can have multiple accounts, each with a unique account number. The application also tracks customer balances and provides security features like PIN verification.

## Features
- **Create a new account** for a new or returning customer with an initial deposit.
- **Access existing accounts** using a secure PIN.
- **Deposit and withdrawal** with transaction details displayed.
- **Account balance management** and the ability to close accounts.
- **Transaction security** with PIN verification.
- **User interface** with a simple menu system for easy navigation.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Use of classes, methods, and appropriate access modifiers

## Project Structure

### Classes
- **Main**: Contains the `main` method to run the application.
- **Menu**: Displays the menu options and handles user interaction for managing accounts.
- **Bank**: Manages a list of customers, allows customer lookup by PIN, and handles customer management.
- **Customer**: Holds customer data (name, PIN) and manages the customer's accounts.
- **Account**: Handles account-related information such as balance, account number, and transactions.

### Key Methods
- **Account Class**:
  - `deposit(double amount)`: Deposits an amount into the account and displays the transaction details.
  - `withdraw(double amount)`: Withdraws an amount from the account, ensuring there are sufficient funds.
  - `toString()`: Returns a string representation of the account with account number and balance.
  
- **Customer Class**:
  - `addAccount(Account account)`: Adds a new account to the customer's list.
  - `removeAccount(Account account)`: Removes an account from the customer's list.
  - `getAccountByNumber(int accountNumber)`: Retrieves an account by its account number.
  - `toString()`: Returns a string representation of the customer's name and PIN.

- **Bank Class**:
  - `addCustomer(Customer customer)`: Adds a customer to the bank's customer list.
  - `removeCustomer(Customer customer)`: Removes a customer from the bank's customer list.
  - `getCustomerByPin(int pin)`: Retrieves a customer by their PIN.

- **Menu Class**:
  - `displayMenu()`: Displays the main menu and handles the user’s input.
  - Methods for accessing accounts, creating new accounts, and closing accounts.

## Example Usage
1. **Open a New Account**:
   - The customer is prompted to enter whether they are a new or returning customer.
   - A new account is created with an initial deposit.

2. **Access an Existing Account**:
   - The customer is asked to enter their PIN.
   - They can view their account details and make deposits or withdrawals.

3. **Close All Accounts**:
   - The customer can close all their accounts by providing their PIN.

4. **Exit the Application**:
   - The user can exit the system at any time.

Files Structure
Main.java: The entry point of the application.
Menu.java: Contains methods to handle the menu and user inputs.
Bank.java: Manages the list of customers.
Customer.java: Handles customer-related functionality.
Account.java: Manages individual bank account details.

Example Output
text
Copy code
************ MENU ************
Please make a selection: 
1) Access Account
2) Open a New Account
3) Close All Accounts
4) Exit
>> 2
Are you a new customer? (yes/no): yes
Enter your first name: John
Enter your last name: Doe
Enter a 4-digit PIN: 1234
Enter the initial deposit amount: 1000
New Account Opened: Account Number: 1001, Balance: $1000.0

