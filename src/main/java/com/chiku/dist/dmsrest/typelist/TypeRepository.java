package com.chiku.dist.dmsrest.typelist;

import com.chiku.dist.dmsrest.screens.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
