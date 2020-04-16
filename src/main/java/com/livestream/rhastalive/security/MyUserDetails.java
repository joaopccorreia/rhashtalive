package com.livestream.rhastalive.security;

import com.livestream.rhastalive.model.users.Role;
import com.livestream.rhastalive.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class MyUserDetails implements UserDetails {
    private String password;
    private String username;
    private boolean isActive;
    private List<SimpleGrantedAuthority> grantedAuthorityList;

    public MyUserDetails(User user) {
        this.password = new BCryptPasswordEncoder().encode(user.getPassword());
        this.username = user.getUserName();
        this.isActive = user.isActive();
        this.grantedAuthorityList = convertRolesToAuthority(user.getRoles());
    }

    public MyUserDetails(){}

    private List<SimpleGrantedAuthority> convertRolesToAuthority(List<Role> roles) {

        LinkedList<SimpleGrantedAuthority> simpleGrantedAuthorities = new LinkedList<>();

        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return simpleGrantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
