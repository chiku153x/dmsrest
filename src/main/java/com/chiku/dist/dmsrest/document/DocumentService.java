package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
	private final DocumentRepository documentRepository;

	@Autowired
	public DocumentService(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public List<Document> getDocumentList(Long number) {
		return documentRepository.findAll().stream().filter(f -> f.getNumber().longValue() == number).collect(Collectors.toList());
	}

	public void addNewDocument(Document document) {
		document.setCreatedDate(new Date());
		documentRepository.save(document);
	}

	public void deleteDocument(Long documentId) {
		if (!documentRepository.existsById(documentId)) {
			throw new IllegalStateException("No document associated with id : " + documentId);
		}
		documentRepository.deleteById(documentId);
	}
}
