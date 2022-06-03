package com.chiku.dist.dmsrest.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentMeta, Long> {
	@Query("SELECT d FROM DocumentMeta d where d.number= ?1")
	Optional<DocumentMeta> findDocumentMetaByNumber(String number);
}
