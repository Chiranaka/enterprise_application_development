/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Chiranaka
 */
//public class DBconnection {
//
//    static Connection con;
//
//    public static Connection DatabaseConnection() {
//        try {
//            String dbpath = "jdbc:mysql://localhost:3306/Drum Zone";
//            con = DriverManager.getConnection(dbpath, "root", "");
//            System.out.println("Connected Successfully");
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return con;
//    }
//
//    public static void main(String args[]) {
//        DatabaseConnection();
//    }
//}

public class DBconnection {

    private static Connection con = null;

    public static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Drum Zone", "root", "");
            return con;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
//            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
