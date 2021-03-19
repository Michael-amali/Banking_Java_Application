package classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void getName() {
        Customer customer = new Customer("Tim",55);
        assertEquals("Tim",customer.getName());
    }

    @Test
    public void getTransactions() {
        Customer customer = new Customer("Tim",55);
        if(customer.getTransactions().isEmpty()){
            System.out.println("Array list is Empty");
        }else{
            System.out.println("List is not Empty");
            System.out.println(customer.getTransactions().get(0));
        }
        double value = 55;

        assertEquals(value,customer.getTransactions().get(0),0);

    }

    @Test
    public void addTransaction() {

        Customer customer = new Customer("Tim",55);
        customer.addTransaction(55);
        double total = customer.getTransactions().get(0)+ customer.getTransactions().get(1);
        assertEquals(total, total,0);
    }
}