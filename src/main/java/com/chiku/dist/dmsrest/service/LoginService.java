package com.chiku.dist.dmsrest.service;

import com.chiku.dist.dmsrest.model.Login;
import com.chiku.dist.dmsrest.repository.LoginRepository;
import com.chiku.dist.dmsrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public String validateUser(String userName, String password){
        final Optional<User> userByCred = loginRepository.findUserByCred(userName, password);
        if(userByCred.isEmpty()){
            return null;
        }

        Supplier<String> tokenSupplier = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID()).toString();
        };
        System.out.println(tokenSupplier.get());

        return tokenSupplier.get();
    }

    @Transactional
    public void addNewToken(String userName, String token) {
        deleteTokenByUser(userName);
        Login login = new Login();
        login.setUser(userName);
        login.setToken(token);
        login.setCreatedOn(new Date());
        loginRepository.save(login);
    }

    @Transactional
    public void deleteTokenByUser(String user){
        loginRepository.deleteByName(user);
    }

    public Optional<Login> validateToken(String token) {
        return loginRepository.findLoginByToken(token);
    }


}
