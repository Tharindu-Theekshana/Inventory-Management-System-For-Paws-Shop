

package com.mycompany.pawsshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PawsShop {

    private static void loadPetSupplies(ArrayList<PetSupplies> petsupplies) {
        try (BufferedReader reader = new BufferedReader(new FileReader("pawsShop.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                if (line.startsWith("Product Category Number")) {
                    String category = line.split("-")[1].trim();
                    String name = reader.readLine().split("-")[1].trim();

                    
                    double price = Double.parseDouble(reader.readLine().split("-")[1].trim().replace("LKR", "").trim());
                    int quantity = Integer.parseInt(reader.readLine().split("-")[1].trim().replace("Instock", "").trim());

                    PetSupplies petSupply = new PetSupplies(category, name, price, quantity);
                    petsupplies.add(petSupply);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading pet supplies: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }

    private static void loadCashierAccounts(ArrayList<Cashier> cashiers) {
        try (BufferedReader reader = new BufferedReader(new FileReader("cashierAccounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Cashier Account Username")) {
                    String username = line.split(":")[1].trim();
                    String password = reader.readLine().split(":")[1].trim();
                    Cashier cashier = new Cashier(username, password);
                    cashiers.add(cashier);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading cashier accounts: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<PetSupplies>petsupplies = new ArrayList<>();
        ArrayList<Cashier>cashiers = new ArrayList<>();
        
        loadCashierAccounts(cashiers);
        loadPetSupplies(petsupplies);
        
        Manager manager = new Manager("manager","manager123");
        
        int role = 0;
        
       while(role != 4)
       { System.out.println("\n       PAWS SHOP\n");
        
        System.out.print("1.Cashier\n2.Manager\n3.Help\n4.Exit\nEnter User Role Number:  ");
        role = scanner.nextInt();
        
        switch(role){
        
            case 1 : 
               
                if (cashiers.isEmpty()){
                
                    System.out.println("\nNo Cashier Acount created! please contact manager");
                }else{
                    while(true){
                        
                        System.out.print("\nEnter Username : ");
                        String cashier_username = scanner.next();
                        System.out.print("Enter Password : ");
                        String cashier_password = scanner.next();
                        
                        for(Cashier c: cashiers){
                            
                            if(cashier_username.equals(c.getUsername()) && cashier_password.equals(c.getPassword())){
                                
                                System.out.println("\nSuccessfully loged to Cashier account!");
                                int choice1 = 0;
                                
                                while(choice1 != 4){
                                
                                    System.out.print("\n1.Add Pet Supplies\n2.View pet Supplies\n3.Search Pet Supplies\n4.Logout\nEnter choice Number : ");
                                    choice1 = scanner.nextInt();
                                    
                                    switch(choice1){
                                    
                                        case 1: 
                                            
                                            c.addPetSupplies(petsupplies);
                                            
                                            break;
                                        case 2:
                                            
                                            c.viewPetSupplies(petsupplies);
                                            
                                            break;
                                        case 3:
                                            
                                            c.seacrhPetSupplies(petsupplies);
                                            
                                            break;
                                        case 4:
                                            System.out.println("\nSuccessfully logouted from Cashier account!");
                                            break;
                                        default :
                                            System.out.println("\nInvalid number! Please enter number between 1 - 4 ");
                                            break;
                                            
                                    }
                                    
                                }
                                                
                    
                              }else{
                        
                                  System.out.println("\nIncorrect username and password! Please try again");
                              }
                            
                       }
                        break;
                    }
                }
                
                
                
                
                break;
                
            case 2 :
               
                int choice2 = 0;
                while(true){
                
                    System.out.print("\nEnter Username : ");
                    String username = scanner.next();
                    
                    System.out.print("Enter Password : ");
                    String password = scanner.next();
                    
                    if(username.equals(manager.getUsername()) && password.equals(manager.getPassword())){
                        
                        System.out.println("\nSuccessfully loged to Manager account!");
                        
                        while(choice2 != 5){
                        
                            System.out.print("\n1.Add Pet Supplies\n2.View pet Supplies\n3.Search Pet Supplies\n4.Create cashier Account\n5.Logout\nEnter choice Number : ");
                            choice2 = scanner.nextInt();
                            
                            switch(choice2){
                            
                                case 1:
                                    
                                    manager.addPetSupplies(petsupplies);
                                    
                                    break;
                                
                                case 2:
                                    
                                    manager.viewPetSupplies(petsupplies);
                                    
                                    break;
                                case 3:
                                    
                                    manager.seacrhPetSupplies(petsupplies);
                                    
                                    break;
                                case 4:
                                    manager.createCashierAccount(cashiers);
                                    break;
                                case 5:
                                    System.out.println("\nSuccessfully logouted from Manager account!\n");
                                    break;
                                default :
                                    System.out.println("\nInvalid number please enter number between 1 - 5!\n");
                                    break;
                            }
                        }
                        break;
                        
                    }else{
                    
                        System.out.println("\nIncorrect username and password! Please try again\n");
                    }
                }
                
                
                
                break;
                
                
                
            case 3 :
                
                System.out.println("\n   User help\n-> Manager can login to the system by entering valid username and password\n-> Only manager can create cashier account for cashier using Create cashier Account option\n-> After creating cashier account, Cashier can login to the system by entering valid username and password\n-> Cashier and manager both can add products to the system and pawsShop file using Add Pet Supplies option\n-> Cashier and manager both can view added products using View pet Supplies option\n-> Cashier and manager both can search products by entering category number using Search Pet Supplies option\n-> Category numbers are - 1.Pet toys / 2.Harnesses / 3.Cages / 4.Cages / 5.Grooming products / 6.Collars / 7.Pet food / 8.Other\n");
                
                break;
                
            case 4 :
                System.out.println("\nSeccessfully Exited from the system!");
                break;
                
            default :
                System.out.println("\nInvalid Number! Please Enter number between 1 - 3");
                break;
            
        }
    }
        
  }
}
