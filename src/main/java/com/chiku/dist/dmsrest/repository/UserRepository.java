package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u where u.userName= :userName")
	Optional<User> findUserByUserName(String userName);
}
