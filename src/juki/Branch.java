package juki;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addNewCustomer(String customerName, double initialAmount){      //to check if customer already exists
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName, initialAmount));
                return true;
            }
         return  false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);//we will update existing customer
        if(existingCustomer != null) {
           existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer (String customerName){
        for (int i = 0; i <this.customers.size() ; i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName))
                return  checkedCustomer;
                 }
                return null;
       }

}
