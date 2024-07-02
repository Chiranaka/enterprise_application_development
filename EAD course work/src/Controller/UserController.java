package Controller;

import Model.*;
import impl.UserImpl;
import java.sql.SQLException;

public class UserController {
    
    public static void registerUser(String name, String email, String address,
            String contact, String dtype, String passwd, String userId) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setAddress(address);
        userModel.setContact(contact);
        userModel.setDtype(dtype);
        userModel.setPasswd(passwd);
        userModel.setUserId(userId);
        
        UserImpl userImpl = new UserImpl();
        userImpl.addUser(userModel);
        
    }
}
