package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="authorities")
@IdClass(AuthorityPk.class)
public class Authority {
    @Id
    @Column(name = "username")
    String username;
    @Id
    String authority;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false, insertable = false)
    User user;

    public Authority() {
    }

    public Authority(String username, String authority, User user) {
        this.username = username;
        this.authority = authority;
        this.user = user;
    }

    public Authority( User user,String authority)
    {
        this.authority = authority;
        this.user = user;
        this.username = user.getUsername();
    }

    public String getUsername() {
        return username;
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
}
