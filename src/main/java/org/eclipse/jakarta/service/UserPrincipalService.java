package org.eclipse.jakarta.service;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.eclipse.jakarta.db.UserPrincipalDAO;
import org.eclipse.jakarta.model.UserPrincipal;
import org.mindrot.jbcrypt.BCrypt;

@Stateless
public class UserPrincipalService {
    @EJB
    private UserPrincipalDAO upDAO;

    @Transactional
    public UserPrincipal create(String username, String password) {
        String encryptPass = BCrypt.hashpw(password, BCrypt.gensalt());
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setUsername(username);
        userPrincipal.setPassword(encryptPass);
        userPrincipal.setCreatedBy(username);
        userPrincipal.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return upDAO.create(userPrincipal);
    }
}
