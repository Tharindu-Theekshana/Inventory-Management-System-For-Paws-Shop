
package com.mycompany.pawsshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cashier extends User{
    
    Scanner scanner = new Scanner(System.in);
    
    public Cashier(String username, String password) {
        super(username, password);
    }
    
    public void addPetSupplies(ArrayList<PetSupplies>petsupplies){
    
        System.out.print("\nEnter Category Number (1.Pet toys / 2.Harnesses / 3.Cages / 4.Cages / 5.Grooming products / 6.Collars / 7.Pet food / 8.Other) : ");
        String category = scanner.next();
        
        System.out.print("Enter Product Name : ");
        String name = scanner.next();
        System.out.print("Enter Price ( numbers only ) : ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity ( numbers only ) : ");
        int quantity = scanner.nextInt();
        
        PetSupplies petSupplie = new PetSupplies(category, name, price, quantity);
        petsupplies.add(petSupplie);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pawsShop.txt", true))) { 
            writer.append("\nProduct Category Number - " + category + "\nProduct name - " + name + "\nProduct Price - LKR" + price + "\nProduct Quantity - " + quantity + " Instock\n");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\nProduct added to the system suuccessfully!");
        
    }
    public void viewPetSupplies(ArrayList<PetSupplies>petsupplies){
    
        System.out.println("\nCategories - 1.Pet toys / 2.Harnesses / 3.Cages / 4.Cages / 5.Grooming products / 6.Collars / 7.Pet food / 8.Other");
        if(petsupplies.isEmpty()){
        
            System.out.println("\nNo pet supplies!\n");
        }else{
          for(PetSupplies p : petsupplies){
        
            System.out.println("\nProduct Category Number - " + p.getcategory() + "\nProduct Name - " + p.getName() + "\nProduct Price - LKR" + p.getPrice() + "\nProduct Quantity - " + p.getQuantity() + " Instock");
         }
        }
    }
    public void seacrhPetSupplies(ArrayList<PetSupplies>petsupplies){
    
        
        System.out.print("\nEnter Product category number to Search (1.Pet toys / 2.Harnesses / 3.Cages / 4.Cages / 5.Grooming products / 6.Collars / 7.Pet food / 8.Other) : ");
        String catNum = scanner.next();
        
        boolean found = false;
        
        for(PetSupplies p : petsupplies){
        
            if(catNum.equals(p.getcategory())){
            
                System.out.println("\nProduct name - " + p.getName() + "\nProduct Price - " + p.getPrice() + "\nProduct Quantity - " + p.getQuantity() + " Instock");
            
                found = true;
              }
            
        }
      if(found != true){
      
          System.out.println("\nNo products for searched category\n");
      }
    }

    
    
}
