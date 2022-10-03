package com.chiku.dist.dmsrest.util;

import com.chiku.dist.dmsrest.login.Login;
import com.chiku.dist.dmsrest.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TokenValidator {
    private final LoginService loginService;

    public static Map<String,Boolean> isLoggedIn = new HashMap<>();

    @Autowired
    public TokenValidator(LoginService loginService){
        this.loginService = loginService;
    }

    public void isTokenValid(String token){
        Optional<Login> login =  loginService.validateToken(token);
        if(login.isPresent()){
            isLoggedIn.put(token,true);
        }else{
            isLoggedIn.put(token,false);
        }
    }


}
