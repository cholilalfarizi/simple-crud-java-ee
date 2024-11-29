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
import org.mindrot.jbcrypt.BCrypt;

@RequestScoped
@Path("account")
public class UserPrincipalResource {
    @EJB
    private UserPrincipalDAO upDAO;

    @EJB
    private UserDetailDAO udDao;

    @EJB
    private AccountDAO accountDAO;

    @POST
    @Consumes("application/json")
    public UserPrincipal create(
            CreateUserRequest request) {

        Account account = new Account();
        account.setBalance(request.getBalance());
        account.setCurrency(request.getCurrency());
        account.setCreatedBy(request.getUsername());

        accountDAO.create(account);

        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(request.getAddress());
        userDetail.setName(request.getName());
        userDetail.setPhone(request.getPhone());
        userDetail.setCreatedBy(request.getUsername());
        userDetail.setAccount(account);

        udDao.create(userDetail);

        String encryptPass = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setUsername(request.getUsername());
        userPrincipal.setPassword(encryptPass);
        userPrincipal.setUserDetail(userDetail);
        userPrincipal.setCreatedBy(request.getUsername());

        return upDAO.create(userPrincipal);
    }
}
