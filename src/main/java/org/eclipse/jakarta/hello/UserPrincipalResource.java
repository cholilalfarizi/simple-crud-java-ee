package org.eclipse.jakarta.hello;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.jakarta.db.AccountDAO;
import org.eclipse.jakarta.db.UserDetailDAO;
import org.eclipse.jakarta.db.UserPrincipalDAO;
import org.eclipse.jakarta.dto.CreateUserRequest;
import org.eclipse.jakarta.model.Account;
import org.eclipse.jakarta.model.UserDetail;
import org.eclipse.jakarta.model.UserPrincipal;
import org.eclipse.jakarta.service.TransactionService;
import org.eclipse.jakarta.service.UserDetailService;
import org.mindrot.jbcrypt.BCrypt;

@RequestScoped
@Path("account")
public class UserPrincipalResource {

    @EJB
    private TransactionService transactionService;

    @POST
    @Consumes("application/json")
    public String create(
            CreateUserRequest request) {

        return transactionService.createUserWithDetailsAndAccount(request);
    }
}
