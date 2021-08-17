package com.login.service;

import com.login.DAO.UserDAO;
import com.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userServiceImp")
public class UserServiceImp implements com.login.service.UserService {
    @Autowired
    UserDAO userDAO;

    public int add(User user){
         int i = userDAO.add(user);
         return i;
    }

    public User getUserByEmail(String email)
    {
        return userDAO.getUserByEmail(email);
    }

    public User getUserById(int id)
    {
        return userDAO.getUserById(id);
    }
    public Long getCount(int status)
    {
        return userDAO.getCount(status);
    }
    public List<User> getAllUser()
    {
        return userDAO.getAllUser();
    }
    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }

    public UserDAO getUsersDAO(){
        return userDAO;
    }

    public void setUsersDAO(){
        this.userDAO = userDAO;
    }


}
