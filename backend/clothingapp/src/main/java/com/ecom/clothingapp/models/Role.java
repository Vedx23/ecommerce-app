package com.ecom.clothingapp.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ROLE_ADMIN, ROLE_USER, ROLE_SELLER;

    @Override
    public String getAuthority() {
        return name();
    }
}