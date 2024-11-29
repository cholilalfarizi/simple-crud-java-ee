package org.eclipse.jakarta.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    @Getter(value = AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserPrincipal userPrincipal;

    @OneToOne(mappedBy = "userDetail")
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
