/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import DatabaseConnection.DBconnection;
import Model.UserModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Chiranaka
 */
public class UserImpl {

//    public void registerUser(String name, String address, String contact, String dtype, String passwd, String email) {
//        try {
//            Connection connection = DBconnection.createConnection();
//            String sql = "INSERT INTO user_info(username,address,contact_number,drumming_type,Password,Email) VALUES('" + name + "','" + address + "','" + contact + "','" + dtype + "','" + passwd + "','" + email + "') ";
//            int count = connection.createStatement().executeUpdate(sql);
//
//            if (count > 0) {
//                JOptionPane.showMessageDialog(null, "Registered", "info", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public static void main(String args[]) {
//        UserModel user = new UserModel();
//        user.registerUser("Samantha", "samantha@gmail.com", "0775005069", "Acoustic", "ftt", "samantha@gmailcom");
//    }

    public void addUser(UserModel user) throws SQLException {
        Connection con = DBconnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into user_info(username, userID, Password, "
                + "Email, contact_number, drumming_type, address) values(?,?,?,?,?,?,?) ");
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserId());
        ps.setString(3, user.getPasswd());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getContact());
        ps.setString(6, user.getDtype());
        ps.setString(7, user.getAddress());
        ps.executeUpdate();
        ps.close();

    }

}
