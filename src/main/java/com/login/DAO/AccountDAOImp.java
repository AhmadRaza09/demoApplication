package com.login.DAO;

import com.login.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("accountDao")
public class AccountDAOImp implements AccountDAO{
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public int add(Account account){
        Integer i = (Integer) this.hibernateTemplate.save(account);
        return  i;
    }

    @Override
    @Transactional
    public void updateAccount(Account account){
        this.hibernateTemplate.update(account);
    }
}
