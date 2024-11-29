package org.eclipse.jakarta.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit_log")
// @NamedQuery(name = "AuditLog.findAll", query = "SELECT a FROM AuditLog a")
public class AuditLog {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @Getter(value = AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private String activity;

    @Column(nullable = false)
    @Getter(value = AccessLevel.NONE)
    private Timestamp time;

    @Column(nullable = false)
    private String actor;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserPrincipal userPrincipal;

    public String getId() {
        return id.toString();
    }

    public String getTime() {
        return time.toString();
    }

    // Getters and Setters
}
