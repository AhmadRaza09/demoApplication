package com.login.DAO;

import com.login.model.Account;

public interface AccountDAO {
    public int add(Account account);
    public void updateAccount(Account account);
}
