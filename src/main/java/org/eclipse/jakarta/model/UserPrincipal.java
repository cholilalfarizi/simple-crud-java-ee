package org.eclipse.jakarta.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "user_principal")
public class UserPrincipal {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @Getter(value = AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_at")
    @Getter(value = AccessLevel.NONE)
    private Timestamp createdAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_at")
    @Getter(value = AccessLevel.NONE)
    private Timestamp modifiedAt;

    @OneToOne(mappedBy = "userPrincipal")
    private UserDetail userDetail;

    @OneToOne(mappedBy = "userPrincipal")
    private Account account;

    public String getId() {
        return id.toString();
    }

    public String getCreatedAt() {
        return createdAt != null ? createdAt.toString() : null;
    }

    public String getModifiedAt() {
        return modifiedAt != null ? modifiedAt.toString() : null;
    }

}
