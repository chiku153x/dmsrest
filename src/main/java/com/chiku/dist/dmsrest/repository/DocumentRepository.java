package com.chiku.dist.dmsrest.repository;

import com.chiku.dist.dmsrest.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	@Query("SELECT d FROM Document d where d.number= ?1")
	Optional<Document> findDocumentMetaByNumber(String number);
}
