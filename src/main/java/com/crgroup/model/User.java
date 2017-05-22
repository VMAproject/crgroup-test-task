package com.crgroup.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User extends BaseModel implements Serializable, UserDetails {
    @JsonIgnore
    private static final long serialVersionUID = 6534751544232619891L;

    public static enum Role {
        ROLE_ADMIN, ROLE_USER
    }

    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private boolean enabled = true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public User() {
    }

    public User(String username, String email, String password, Role role) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @JsonIgnore
    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}