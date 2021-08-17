package com.login.beans;

import com.login.model.User;
import com.login.service.UserServiceImp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "deleteUser")
@RequestScoped
public class DeleteUser {
    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;

    public String delete(int id)
    {
        User user =  userServiceImp.getUserById(id);
        if(user.getAccount().getRole().getId() != 1)
        {
            user.setStatus(3);
            userServiceImp.updateUser(user);
        }
        return "allUserRecords?faces-redirect=true";
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }
}
