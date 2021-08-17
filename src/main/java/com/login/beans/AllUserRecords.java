package com.login.beans;


import com.login.helper.HelperUserRecords;
import com.login.model.User;
import com.login.service.UserServiceImp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "allUserRecords")
@RequestScoped
public class AllUserRecords {
    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;
    private ArrayList<HelperUserRecords> allUsers;



    public void setAllUsers(ArrayList<HelperUserRecords> allUsers) {
        this.allUsers = allUsers;
    }

    public ArrayList<HelperUserRecords> getAllUsers() {
        return allUsers;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
        List<User> users =  userServiceImp.getAllUser();
        ArrayList<HelperUserRecords> helperUser = new ArrayList<HelperUserRecords>();
        for (int i = 0; i<users.size(); i++)
        {
            User tempUser = users.get(i);
            HelperUserRecords temHelperUser = new HelperUserRecords(tempUser.getId(), (i+1), tempUser.getFirstName() + " " + tempUser.getLastName(),
                    tempUser.getAccount().getEmail(), tempUser.getGender(), tempUser.getMobile(), tempUser.getAccount().getRole().getRole(), tempUser.getStatus());
            helperUser.add(temHelperUser);
        }
//
        setAllUsers(new ArrayList<HelperUserRecords>(helperUser));
    }
}
