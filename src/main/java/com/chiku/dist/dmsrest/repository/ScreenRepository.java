package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
	@Query("SELECT s FROM Screen s where s.screenNumber= ?1")
	Optional<Screen> findScreenByNumber(String number);

	@Query("SELECT s FROM Screen s where s.screenName= ?1")
	Optional<Screen> findScreenByName(String name);
}
