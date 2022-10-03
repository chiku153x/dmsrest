package com.chiku.dist.dmsrest.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping(path = "/validate")
    public ResponseEntity createSession(@RequestBody Credential credential) {
        String token = loginService.validateUser(credential.getUserName(),credential.getPassword());
        if(null != token){
            loginService.addNewToken(credential.getUserName(),token);
            return new ResponseEntity(token, HttpStatus.OK);
        }else {
            Map<String,String> message = new HashMap<>();
            message.put("message","Login Error");
            return new ResponseEntity(message, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(path = "/token/{token}")
    public ResponseEntity isValidToken(@PathVariable("token") String token){
        Optional<Login> login = loginService.validateToken(token);
        if(login.isEmpty()){
            Map<String,String> message = new HashMap<>();
            message.put("message","Invalid Token");
            return new ResponseEntity(message, HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity(login, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/logout/{user}")
    public ResponseEntity logout(@PathVariable("user") String user){
        loginService.deleteTokenByUser(user);
        Map<String,String> message = new HashMap<>();
        message.put("message","Logout successful");
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
