package com.login.beans;



import com.login.service.UserServiceImp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "dashboard")
@RequestScoped
public class Dashboard {
    @ManagedProperty(value = "#{userServiceImp}")
    UserServiceImp userServiceImp;
    private Long totalUsers;
    private Long activeUsers;
    private Long pendingUsers;
    private Long deletedUsers;



    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
        setActiveUsers(userServiceImp.getCount(1));
        setDeletedUsers(userServiceImp.getCount(3));
        setPendingUsers(userServiceImp.getCount(2));
        setTotalUsers(userServiceImp.getCount(0));

    }

    public Long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Long getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Long activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Long getPendingUsers() {
        return pendingUsers;
    }

    public void setPendingUsers(Long pendingUsers) {
        this.pendingUsers = pendingUsers;
    }

    public Long getDeletedUsers() {
        return deletedUsers;
    }

    public void setDeletedUsers(Long deletedUsers) {
        this.deletedUsers = deletedUsers;
    }
}
