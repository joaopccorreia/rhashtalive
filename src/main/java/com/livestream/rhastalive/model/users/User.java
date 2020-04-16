package com.livestream.rhastalive.model.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    private String userName;
    private String password;
    private boolean active;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userName"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public boolean isActive() {
        return active;
    }
}
