package org.eclipse.jakarta.db;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.eclipse.jakarta.model.AuditLog;

@Stateless
public class AuditLogDAO {
    @PersistenceContext(unitName = "hello_PU")
    EntityManager em;

    public List<AuditLog> getAll() {
        return em.createQuery("SELECT a FROM AuditLog a", AuditLog.class).getResultList();
    }
}
