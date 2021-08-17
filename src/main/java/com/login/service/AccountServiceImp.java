package com.login.service;

import com.login.DAO.AccountDAO;
import com.login.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountServiceImp")
public class AccountServiceImp implements com.login.service.AccountService {
    @Autowired
    AccountDAO accountDao;

    public void add(Account account){
        accountDao.add(account);
    }

    public void updateAccount(Account account){
        accountDao.updateAccount(account);
    }

    public AccountDAO getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDAO accountDao) {
        this.accountDao = accountDao;
    }
}
