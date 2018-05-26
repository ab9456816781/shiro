package com.shiro.demo.model;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Integer rid;

    private String rname;

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();

    public int getRid() {
        return rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
