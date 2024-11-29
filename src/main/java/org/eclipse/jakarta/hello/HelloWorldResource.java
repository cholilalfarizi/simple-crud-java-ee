package org.eclipse.jakarta.hello;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.jakarta.db.DatabaseConnection;
import org.eclipse.jakarta.model.AuditLog;

@Path("hello")
@RequestScoped
public class HelloWorldResource {

	@PersistenceContext(unitName = "hello_PU")
	private EntityManager entityManager;
	@Inject
	private DatabaseConnection databaseConnection;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Hello hello(@QueryParam("name") String name) {
		// if ((name == null) || name.trim().isEmpty()) {
		// name = "world";
		// }
		AuditLog log = new AuditLog();
		log.setActivity("Hello " + name);
		entityManager.persist(log);
		try (Connection connection = databaseConnection.getConnection()) {
			System.out.println("Koneksi berhasil!");
			name = "Koneksi berhasil!";
		} catch (SQLException e) {
			System.err.println("Koneksi gagal: " + e.getMessage());
			name = "Koneksi gagal: " + e.getMessage();
		}

		return new Hello(name);
	}
}