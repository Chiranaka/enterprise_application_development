
package impl;

import DatabaseConnection.DBconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Chiranaka
 */
public class SearchItemImpl {
    
    String tableName;
    String brand;
    String size;
    double price;
    
    ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTableName() {
        return tableName;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
    
    
    
    public void fetchsearch(String type,String brand,double maxPrice,JTable table) throws SQLException{
        
        DBconnection db = new DBconnection();
        java.sql.Connection con =DBconnection.getDatabaseConnection();
        try (PreparedStatement ps = con.prepareStatement("SELECT brand,size,price FROM `drum zone`.`"+type+"`where brand='"+brand+"' and price<='"+maxPrice+"';")) {
           
           rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
          
      while(rs.next()){
          
        }
    
    }
    
 
   }
}
