package com.chiku.dist.dmsrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        Map<String,String> response = new HashMap<>();
        Authentication authObject ;
        try {
            authObject = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
            response.put("message","Login Successful");
            return new ResponseEntity(response,HttpStatus.OK);
        } catch (BadCredentialsException e) {
            response.put("message","Login failed");
            return new ResponseEntity(response,HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/logoutmsg")
    public ResponseEntity logoutMessage(){
        Map<String,String> response = new HashMap<>();
        response.put("message","Logout Successful");
        return new ResponseEntity(response,HttpStatus.OK);
    }

}
