package com.login.DAO;

import com.login.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("roleDao")
public class RoleDAOImp implements com.login.DAO.RoleDAO {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public int add(Role role) {
        Integer i = (Integer) this.hibernateTemplate.save(role);
        return  i;
    }
}
