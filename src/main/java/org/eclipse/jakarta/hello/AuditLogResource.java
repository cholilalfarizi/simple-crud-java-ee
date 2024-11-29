package org.eclipse.jakarta.hello;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jakarta.db.AuditLogDAO;

@RequestScoped
@Path("audit")
public class AuditLogResource {
    @Inject
    private AuditLogDAO auditLogDAO;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAll() {
        return Response.ok(auditLogDAO.getAll()).build();
    }
}
