package com.chiku.dist.dmsrest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT d FROM User d where d.userId= ?1")
	Optional<User> findUserByNumber(Long number);
}
