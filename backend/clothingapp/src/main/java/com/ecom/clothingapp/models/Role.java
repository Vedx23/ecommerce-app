package com.ecom.clothingapp.models;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private final Authority authority;

    public Role(Authority authroity) {
        this.authority = authroity;
    }

    @Override
    public String getAuthority() {
        return this.authority.toString();
    }

}
