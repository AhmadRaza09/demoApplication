package com.login.beans;

import com.login.model.User;
import com.login.service.UserServiceImp;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean(name = "authenticateUser")
@RequestScoped
public class AuthenticateUser implements Serializable {
    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;
    private static final long serialVersionUID = 4672207931321758371L;
    private String email;
    private  String password;
    private int status = 1;
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login()
    {
        User user = userServiceImp.getUserByEmail(getEmail());
//        HttpSession session = SessionUtils.getSession();
        if(getEmail().equals(user.getAccount().getEmail()) && getPassword().equals(user.getAccount().getPassword()) && status == user.getStatus())
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("userName", user.getFirstName());
            session.setAttribute("userId", user.getId());
            session.setAttribute("status", user.getAccount().getRole().getId());

            if((Integer) session.getAttribute("status") == 1)
            {
                return "adminDashboard?faces-redirect=true";
            }
            return "user?faces-redirect=true";

        }
        else
        {
            setMessage("Email or password is incorrect");
            return null;
        }
    }

    public String logout()
    {
//        System.out.println("Hi I am");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        session.removeAttribute("userName");
        session.removeAttribute("userId");
        session.removeAttribute("status");
//        System.out.println("Ahmad Raza");
        return "login.xhtml";
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }
}
