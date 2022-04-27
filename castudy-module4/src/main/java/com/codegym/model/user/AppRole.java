package com.codegym.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( uniqueConstraints = {
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "role_name") })
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UserRole> useRoles;

    public AppRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUseRoles() {
        return useRoles;
    }

    public void setUseRoles(Set<UserRole> useRoles) {
        this.useRoles = useRoles;
    }
}
