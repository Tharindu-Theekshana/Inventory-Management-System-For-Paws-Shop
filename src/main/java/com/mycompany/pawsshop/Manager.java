
package com.mycompany.pawsshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Manager extends Cashier{
    Scanner myscanner = new Scanner(System.in);
    public Manager(String username, String password) {
        super(username, password);
    }
    
    
    public void createCashierAccount(ArrayList<Cashier>cashiers){
    
        System.out.println("\nCreate Username and Password for Cashier account\n");
        
        System.out.print("Username : ");
        String cashierUsername = myscanner.next();
        System.out.print("Password : ");
        String cashierPassword = myscanner.next();
                                    
        Cashier cashier = new Cashier(cashierUsername,cashierPassword);
        cashiers.add(cashier);
        
        try (BufferedWriter writeto = new BufferedWriter(new FileWriter("cashierAccounts.txt", true))) { 
            writeto.append("\nCashier Account Username : " + cashierUsername + "\nCashier Account Password : " + cashierPassword + "\n");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\nCashier account created successfully!\n");
    }
    
}
