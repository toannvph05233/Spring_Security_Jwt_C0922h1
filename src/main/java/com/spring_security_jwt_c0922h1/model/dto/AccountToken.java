package com.spring_security_jwt_c0922h1.model.dto;

import com.spring_security_jwt_c0922h1.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private String username;
    private String avatar;
    private String token;

    private List<Role> roles;
}
