package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.Permission;
import com.chiku.dist.dmsrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query("SELECT p FROM Permission p where p.userName= ?1")
    Optional<User> findPermissionByUserName(String userName);
}
