package juki;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
//every time we are adding a customer, we need to specify Branch name, the customer name and the initial transaction
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);

        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
//every time we are adding a customer transaction, we need to specify Branch name, the customer name and the initial transaction
//addTransactionForExistingCustomerForThatBranch
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getBranchName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    //will return true- if showTransactions have list of transactions for customers, false- if we only want to see the customer names
    public boolean ListCustomers(String branchName, boolean showTransactions) {

        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());
            //we know with witch branch we are dealing with, and we need a List of customers that are part of this branch
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);//the current entry we are working on it now
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");//list all the customers in the given branch
                if (showTransactions) {//if this is true
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    //optionally all transactions for a given customer
                    //it can be multiple transactions so we should print them each out with another loop
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
            }
     }
}


