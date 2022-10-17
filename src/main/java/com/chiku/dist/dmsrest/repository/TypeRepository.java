package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
