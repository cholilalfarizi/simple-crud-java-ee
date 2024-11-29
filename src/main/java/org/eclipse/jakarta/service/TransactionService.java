package org.eclipse.jakarta.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.eclipse.jakarta.dto.CreateUserRequest;
import org.eclipse.jakarta.model.UserPrincipal;

@Stateless
@Transactional
public class TransactionService {
    @EJB
    private UserPrincipalService userPrincipalService;

    @EJB
    private UserDetailService userDetailService;

    @EJB
    private AccountService accountService;

    public String createUserWithDetailsAndAccount(CreateUserRequest request) {
        try {

            UserPrincipal userPrincipal = userPrincipalService.create(request.getUsername(), request.getPassword());

            userDetailService.create(userPrincipal, request.getName(), request.getPhone(), request.getAddress(),
                    request.getUsername());

            accountService.create(userPrincipal, request.getBalance(), request.getCurrency(), request.getUsername());

            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error terjadi: " + e.getMessage(), e);
        }
    }
}
