package com.login.beans;

import com.login.helper.HelperUserDetail;
import com.login.model.User;
import com.login.service.UserServiceImp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name = "userDetail")
@RequestScoped
public class UserDetail {

    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;
    private User user;
    private ArrayList<HelperUserDetail> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsers(ArrayList<HelperUserDetail> users) {
        this.users = users;
    }

    public ArrayList<HelperUserDetail> getUsers() {
        return users;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;

//        get seesion
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

//        get id
        setUser(userServiceImp.getUserById( (Integer) session.getAttribute("userId") ));

//        set Users detail
        setUsers( new ArrayList<HelperUserDetail>(Arrays.asList(
                new HelperUserDetail("Name", user.getFirstName() + " " + user.getLastName()),
            new HelperUserDetail("Email", user.getAccount().getEmail()),
            new HelperUserDetail("Gender", user.getGender()),
            new HelperUserDetail("Mobile", user.getMobile()),
            new HelperUserDetail("Designation", user.getDesignation()),
            new HelperUserDetail("UserType", user.getAccount().getRole().getRole())
        )));

    }
}
