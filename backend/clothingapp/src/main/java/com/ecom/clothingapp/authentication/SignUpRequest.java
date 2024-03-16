package com.ecom.clothingapp.authentication;

import com.ecom.clothingapp.models.AccountStatus;
import com.ecom.clothingapp.models.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private AccountStatus accountStaus;
    private Role role;

}
