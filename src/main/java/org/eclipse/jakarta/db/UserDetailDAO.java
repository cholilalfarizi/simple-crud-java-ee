package org.eclipse.jakarta.db;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.eclipse.jakarta.model.UserDetail;

@Stateless
public class UserDetailDAO {
    @Inject
    private DAO dao;

    public UserDetail create(UserDetail userDetail) {

        return dao.create(userDetail);

    }
}
