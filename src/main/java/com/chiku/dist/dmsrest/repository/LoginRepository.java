package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.Login;
import com.chiku.dist.dmsrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query("SELECT u FROM User u where u.userName= :userName and u.password= :password and u.active=true")
    Optional<User> findUserByCred(String userName,String password);

    @Modifying
    @Query(value = "DELETE FROM Login e WHERE e.user = :name")
    int deleteByName(@Param("name") String name);

    @Query("SELECT l FROM Login l where l.token= :token")
    Optional<Login> findLoginByToken(String token);
}
