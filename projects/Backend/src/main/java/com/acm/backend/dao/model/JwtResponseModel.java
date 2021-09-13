package com.acm.backend.dao.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class JwtResponseModel {

    private String token;
    private String type = "Bearer ";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponseModel(String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = accessToken;
        this.username = username;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
