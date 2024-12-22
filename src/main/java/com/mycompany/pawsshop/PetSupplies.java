
package com.mycompany.pawsshop;

public class PetSupplies {
    
    private String name;
    private String category;
    private double price;
    private int quantity;
    
    public PetSupplies(String category, String name, double price, int quantity){
    
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
    
        return this.name;
    }
    public String getcategory(){
    
        return this.category;
    }
    public double getPrice(){
    
        return this.price;
    }
    public int getQuantity(){
    
        return this.quantity;
    }
}
