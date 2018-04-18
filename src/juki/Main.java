package juki;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Nordea");

        if(bank.addNewBranch("Copenhagen")){
            System.out.println("Copenhagen branch created");
        }

        bank.addCustomer("Copenhagen", "Tim", 50.08);
        bank.addCustomer("Copenhagen", "Juki", 150.09);
        bank.addCustomer("Copenhagen", "Ivan", 35.98);
        bank.addCustomer("Copenhagen", "Andrej", 98.17);

        bank.addNewBranch("Stockholm");
        bank.addCustomer("Stockholm", "Martina", 175.54);

        bank.addCustomerTransaction("Copenhagen", "Juki", 200.50);
        bank.addCustomerTransaction("Copenhagen", "Juki", 100.50);
        bank.addCustomerTransaction("Copenhagen", "Ivan", 500.50);

        bank.ListCustomers("Copenhagen", true);
        bank.ListCustomers("Stockholm", true);

        bank.addNewBranch("Gothenburg");

        if(!bank.addCustomer("Gothenburg", "Mitko", 178.25)){
            System.out.println("Error, Gothenburg branch does not exist.");
        }

        if(!bank.addNewBranch("Copenhagen")){
            System.out.println("Copenhagen branch already exist.");
        }

        if(!bank.addCustomerTransaction("Copenhagen", "Elena", 45.58)){
            System.out.println("Customer does not exist at branch. ");
        }

        if(!bank.addCustomer("Copenhagen", "Juki", 12.56)){
            System.out.println("Customer Juki already exist.");
        }
    }
}
