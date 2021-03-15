package _class;

import _interface.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String customerName, double initialTransaction){
        this.name = customerName;
        this.transactions = new ArrayList<Double>(); ////////// NOT SURE, whether to assign initialTrans to trans
        this.transactions.add(initialTransaction);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    @Override
    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }

}
