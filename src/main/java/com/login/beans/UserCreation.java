package com.login.beans;

import com.login.model.Account;
import com.login.model.Role;
import com.login.model.User;
import com.login.service.AccountServiceImp;
import com.login.service.UserServiceImp;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "userCreation")
@SessionScoped
public class UserCreation {

    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;
    @ManagedProperty(value = "#{accountServiceImp}")
    AccountServiceImp accountServiceImp;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String mobile;
    private String designation;
    private int status; //1 active | 2 pending | 3 deleted
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public AccountServiceImp getAccountServiceImp() {
        return accountServiceImp;
    }

    public void setAccountServiceImp(AccountServiceImp accountServiceImp) {
        this.accountServiceImp = accountServiceImp;
    }

    public String addUser()
    {
//        System.out.println("Why");
        User registerUser = new User();
        Account userAccount = new Account();
        Role userRole = new Role();

        userAccount.setEmail(getEmail());
        userAccount.setPassword(getPassword());

        userRole.setId(getRoleId());
        userAccount.setRole(userRole);

        registerUser.setFirstName(getFirstName());
        registerUser.setLastName(getLastName());
        registerUser.setGender(getGender());
        registerUser.setMobile(getMobile());
        registerUser.setDesignation(getDesignation());
        registerUser.setStatus(getStatus());

        accountServiceImp.add(userAccount);
        registerUser.setAccount(userAccount);

        int i = userServiceImp.add(registerUser);
        return "allUserRecords?faces-redirect=true";
    }

    public String setUserData(int id)
    {


        User user  = userServiceImp.getUserById(id);
        setId(user.getId());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getAccount().getEmail());
        setGender(user.getGender());
        setMobile(user.getMobile());
        setDesignation(user.getDesignation());
        setRoleId(user.getAccount().getRole().getId());
        setPassword(user.getAccount().getPassword());

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        if((Integer) session.getAttribute("status") == 1) //role
        {

            setStatus(user.getStatus());
            setRoleId(user.getAccount().getRole().getId());
            return "updateUser?faces-redirect=true";
        }
        else
            return "updateSimpleUser";
    }

    public String updateUser(int userId)
    {

        User registerUser = userServiceImp.getUserById(id);
        Account userAccount = registerUser.getAccount();
        Role userRole = userAccount.getRole();

        userAccount.setEmail(getEmail());
        userAccount.setPassword(getPassword());

        userRole.setId(getRoleId());
        userAccount.setRole(userRole);

        registerUser.setFirstName(getFirstName());
        registerUser.setLastName(getLastName());
        registerUser.setGender(getGender());
        registerUser.setMobile(getMobile());
        registerUser.setDesignation(getDesignation());
        if(getStatus() == 0)
        {
            setStatus(3);  //for deleted
        }
        registerUser.setStatus(getStatus());

        accountServiceImp.updateAccount(userAccount);
        userServiceImp.updateUser(registerUser);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        if((Integer) session.getAttribute("status") == 1) //role
        {
            return "allUserRecords?faces-redirect=true";
        }
        return "user?faces-redirect=true";
    }

    public String updatePass(){

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        int id = (Integer) session.getAttribute("userId");


        User user = userServiceImp.getUserById(id);
        user.getAccount().setPassword(this.password);
        Account account = user.getAccount();
        accountServiceImp.updateAccount(account);
//        userServiceImp.updateUser(user);


        if((Integer) session.getAttribute("status") == 1) //role
        {
            return "allUserRecords?faces-redirect=true";
        }
        return "user?faces-redirect=true";
    }

    public void clearData()
    {
        setFirstName("");
        setLastName("");
        setEmail("");
        setGender("");
        setMobile("");
        setDesignation("");
        setRoleId(0);
        setStatus(0);
        setPassword("");
    }

}
