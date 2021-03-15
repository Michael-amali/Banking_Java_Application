package classes;

import interfaces.IBank;

import java.util.ArrayList;

public class Bank implements IBank  {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String branchName){
        this.name = branchName;
        this.branches = new ArrayList<Branch>();
    }

    @Override
    public boolean addBranch(String branchName) {      // it must be made PRIVATE per the instructions
        // if it's equal to null, then it does not exist so you need to add it
        if(findBranch(branchName) == null){
            branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    @Override
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {

        Branch checkedBranch = findBranch(branchName);

        if(checkedBranch != null){
            return findBranch(branchName).newCustomer(customerName, initialTransaction);
        }

        return false;
    }

    @Override
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {

        Branch checkedBranch = findBranch(branchName);
        if(checkedBranch != null){
            return findBranch(branchName).addCustomerTransaction(customerName, transaction);
        }

        return false;
    }

    @Override                //it must be made PRIVATE per the instructions so remove from IBank interface
    public Branch findBranch(String branchName) {

        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    @Override
    public boolean listCustomers(String branchName, boolean printTransactions) {

        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch != null) {
            System.out.println("Customer details for branch " + branchName);
            ArrayList<Customer> branchCustomer = checkedBranch.getCustomers();

            for (int i = 0; i < branchCustomer.size(); i++) {
                System.out.println("Customer: " + branchCustomer.get(i).getName() + "["+ (i+1) +"]");

                if (printTransactions) {
                    System.out.println("Transactions ");
                    ArrayList<Double> transactions = branchCustomer.get(i).getTransactions();

                    for (int k = 0; k < transactions.size(); k++) {
                        System.out.println("["+ (k+1) +"]" + " Amount " + transactions.get(k));
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
