package org.eclipse.jakarta.service;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.eclipse.jakarta.db.UserDetailDAO;
import org.eclipse.jakarta.model.UserDetail;
import org.eclipse.jakarta.model.UserPrincipal;

@Stateless
public class UserDetailService {
    @EJB
    private UserDetailDAO udDao;

    @Transactional
    public UserDetail create(
            UserPrincipal userPrincipal,
            String name, String phone, String address,
            String username) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(address);
        userDetail.setName(name);
        userDetail.setPhone(phone);
        userDetail.setCreatedBy(phone);
        userDetail.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userDetail.setUserPrincipal(userPrincipal);

        return udDao.create(userDetail);
    }
}
