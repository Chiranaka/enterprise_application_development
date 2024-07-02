/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Chiranaka
 */
public class CymbalModel {
    int cymbal_id;
    String brand;
    String type;
    String size;
    double price;

    
    public CymbalModel(){}
    
    public CymbalModel(int id,String brand,String type,String size,double price){
        this.cymbal_id=id;
        this.brand=brand;
        this.type=type;
        this.size=size;
        this.price=price;
    
    }
    
    
    public void setCymbal_id(int cymbal_id) {
        this.cymbal_id = cymbal_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCymbal_id() {
        return cymbal_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
    
}
