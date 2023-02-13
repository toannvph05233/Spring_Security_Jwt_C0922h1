package com.spring_security_jwt_c0922h1.controller;

import com.spring_security_jwt_c0922h1.model.Account;
import com.spring_security_jwt_c0922h1.model.dto.AccountToken;
import com.spring_security_jwt_c0922h1.service.AccountService;
import com.spring_security_jwt_c0922h1.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountToken login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());
        AccountToken accountToken = new AccountToken(account1.getUsername(),account1.getAvatar(),token,account1.getRoles());
        return accountToken;
    }
}
