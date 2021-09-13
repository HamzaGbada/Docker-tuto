package com.acm.backend.configuration.security.services;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipale implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String email;
    private String password;


    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipale build(Person person) {
        List<GrantedAuthority> authorities = person.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
        return new UserPrincipale(
                person.getId(),
                person.getUserName(),
                person.getEmail(),
                person.getPassword(),
                authorities
        );
    }


    @Override
    public String getUsername() {
        return userName;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrincipale user = (UserPrincipale) o;
        return Objects.equals(id, user.id);
    }
}

