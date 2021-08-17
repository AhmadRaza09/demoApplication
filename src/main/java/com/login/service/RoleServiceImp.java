package com.login.service;

import com.login.DAO.RoleDAO;
import com.login.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImp implements com.login.service.RoleService {
    @Autowired
    RoleDAO roleDAO;

    public void add(Role role){
        roleDAO.add(role);
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}
