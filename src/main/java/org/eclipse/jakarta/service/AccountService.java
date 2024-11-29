package org.eclipse.jakarta.service;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.eclipse.jakarta.db.AccountDAO;
import org.eclipse.jakarta.model.Account;
import org.eclipse.jakarta.model.UserPrincipal;

@Stateless
public class AccountService {
    @EJB
    private AccountDAO accountDAO;

    @Transactional
    public Account create(
            UserPrincipal userPrincipal,
            BigDecimal balance,
            String currency,
            String username) {
        Account account = new Account();
        account.setBalance(balance);
        account.setCurrency(currency);
        account.setCreatedBy(username);
        account.setUserPrincipal(userPrincipal);
        return accountDAO.create(account);
    }
}
