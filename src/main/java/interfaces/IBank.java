package interfaces;

import classes.Branch;

public interface IBank {

    boolean addBranch(String branchName);
    boolean addCustomer(String branchName, String customerName, double initialTransaction);
    boolean addCustomerTransaction(String branchName, String customerName, double transaction);
    Branch findBranch(String branchName);
    boolean listCustomers(String branchName, boolean printTransactions);
}

