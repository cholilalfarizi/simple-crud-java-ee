package org.eclipse.jakarta.db;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.eclipse.jakarta.model.Account;

@Stateless
public class AccountDAO {
    @Inject
    private DAO dao;

    public Account create(Account account) {

        return dao.create(account);

    }
}
