package com.login.DAO;

import com.login.model.User;

import java.util.List;


public interface UserDAO {
    public int add(User user);
    public User getUserByEmail(String email);
    public User getUserById(int id);
    public Long getCount(int status);
    public List<User> getAllUser();
    public void updateUser(User user);
}
