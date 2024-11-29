package org.eclipse.jakarta.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@ApplicationScoped
public class DatabaseConnection {

    @Resource(name = "PostgresDS")
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
