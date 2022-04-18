package com.codegym.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UseRole> useRoles;

    public Role() {
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

    public Set<UseRole> getUseRoles() {
        return useRoles;
    }

    public void setUseRoles(Set<UseRole> useRoles) {
        this.useRoles = useRoles;
    }
}
