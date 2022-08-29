package com.chiku.dist.dmsrest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u where u.userName= :userName and u.instance= :instance")
	Optional<User> findUserByUserName(String userName, String instance);
}
