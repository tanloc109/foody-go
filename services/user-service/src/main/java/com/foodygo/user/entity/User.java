package com.foodygo.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, nullable = false)
    String username;

    String fullname;

    @Column(unique = true, nullable = false)
    String phone;

    @Column(unique = true, nullable = false)
    String email;

    String password;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return isDeleted;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isDeleted;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isDeleted;
    }

    @Override
    public boolean isEnabled() {
        return !isDeleted;
    }
}
