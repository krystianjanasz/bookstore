package org.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class AuthorityPk implements Serializable {
    String username;
    String authority;

    public AuthorityPk() {
    }

    public String getUsername() {
        return username;
    }

    public AuthorityPk(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityPk that = (AuthorityPk) o;
        return Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }
}