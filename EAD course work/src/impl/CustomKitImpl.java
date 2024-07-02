/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import DatabaseConnection.DBconnection;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Chiranaka
 */
public class CustomKitImpl {

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
   double price;

    public double getPrice() {
        return price;
    }
   
    public void getItemPrice(String table, String brand, String size) throws SQLException {
        DBconnection db = new DBconnection();
        java.sql.Connection con =DBconnection.getDatabaseConnection();
        try (PreparedStatement ps = con.prepareStatement("SELECT price FROM `drum zone`.`"+table+"`where brand='"+brand+"' and size='"+size+"';")) {
           
           
            
            
            ResultSet rs = ps.executeQuery();
            
            price=0.00;
            while(rs.next()){
                price = rs.getDouble("price");
            }
        }
      
        

    }

    
    public static void main(String args[]) throws SQLException{
    
        CustomKitImpl newkit=new CustomKitImpl();
        newkit.getItemPrice("kick drums","dw","22x16");
         double price=newkit.getPrice();
        System.out.println(price);
    }
}
