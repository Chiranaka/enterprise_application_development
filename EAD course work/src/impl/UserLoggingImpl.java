
package impl;

import DatabaseConnection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class UserLoggingImpl {
    
    public boolean checkPasswd(String username,String passwd) throws SQLException{
    String Password="";
    String userName="";
    Connection con = DBconnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("SELECT username,Password FROM `drum zone`.`user_info` where username='"+username+"'");
    ResultSet rs =ps.executeQuery();
    if(rs.next()){
        userName=rs.getString("username");
        Password=rs.getString("Password");
    }
        System.out.println(Password+userName);
        return passwd.equals(Password);
    }
    
    
    
}
