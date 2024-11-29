package org.eclipse.jakarta.db;

import org.eclipse.jakarta.model.UserPrincipal;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Timestamp;
import java.util.UUID;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class UserPrincipalDAO {

    // @PersistenceContext(unitName = "hello_PU")
    // EntityManager em;

    @Inject
    private DAO dao;

    // public void create(UserPrincipal userPrincipal) {
    // em.persist(userPrincipal);
    // }

    public UserPrincipal create(UserPrincipal userPrincipal) {

        return dao.create(userPrincipal);

    }
}
