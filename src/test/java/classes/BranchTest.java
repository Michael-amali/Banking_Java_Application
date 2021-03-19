package classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {


    @Test
    public void getName() {
        Branch branch = new Branch("Adelaide");
        assertEquals("Adelaide",branch.getName());
    }

    @Test
    public void getCustomers() {
        String branchName = "Adelaide";

        //new branch object is created
        Branch branch = new Branch(branchName);

        //Adding few customers
        branch.newCustomer("Tim",20);
        branch.newCustomer("Yaw",50);
        branch.newCustomer("Emma",80);
        //checking if it is not empty
        assertNotNull(branch.getCustomers());
    }

    @Test
    public void newCustomer() {
        String branchName = "Adelaide";

        //new branch object is been created
        Branch branch = new Branch(branchName);

        assertTrue(branch.newCustomer("Tim",50.05));

        //Trying to add an existing customer
        assertFalse(branch.newCustomer("Tim",50.05));
    }

    @Test
    public void addCustomerTransaction() {
        String branchName = "Adelaide";
        Branch branch = new Branch(branchName);

        //Adding a new customer
        branch.newCustomer("Tim",20.00);

        //Adding a transaction to an existing customer
        boolean status = branch.addCustomerTransaction("Tim",60.00);
        //Asserting that the transaction is successful
        assertTrue(status);

        //Adding  a transaction to a non existing customers
        boolean status2 = branch.addCustomerTransaction("Mike",60.00);
        assertFalse(status2);
    }


}