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
public class UserModel {

    private int id;
    private String name;
    private String address;
    private String contact;
    private String dtype;
    private String passwd;
    private String email;
    private String userId;
    
    public UserModel(){}

    public UserModel(int id, String name, String address, String contact, 
            String dtype, String passwd, String email, String userId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dtype = dtype;
        this.passwd = passwd;
        this.email = email;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getDtype() {
        return dtype;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUserId(String userid) {
        this.userId = userid;
    }

}
