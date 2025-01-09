import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customersAccounts = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customersAccounts.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customersAccounts.remove(customer);
    }

    public Customer getCustomerPin(int userPin) {
        for (Customer customer : customersAccounts) {
            if (customer.getUserPin() == userPin) {
                return customer;
            }
        } return null;
    }

    public ArrayList<Customer> getCustomersAccounts() {
        return customersAccounts;
    }
}
