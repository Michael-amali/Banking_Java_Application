package classes;

import interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName){
        this.name = branchName;
        this.customers = new ArrayList<Customer>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {         // it must be made PRIVATE per the instructions
        return this.customers;
    }

    @Override
    public boolean newCustomer(String customerName, double initialTransaction) {
        // if the customer does not exist, then add it to the customers list
        if(findCustomer(customerName) == null){
            customers.add(new Customer(customerName, initialTransaction));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String customerName, double transaction) {
        // if customer already exists then, we can obtain his/her info and add it to the transaction list
        Customer checkedCustomer = findCustomer(customerName);
        if(checkedCustomer != null){
            findCustomer(customerName).addTransaction(transaction);
            return true;
        }
        return false;
    }

    //it must be made PRIVATE per the instructions so remove from IBranch interface
    private Customer findCustomer(String customerName) {

        for(Customer customer: customers){
            if(customer.getName().equals(customerName)){
                return customer;
            }
        }
        return null;
    }
}
