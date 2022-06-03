package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
	private final DocumentRepository documentRepository;

	@Autowired
	public DocumentService(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public List<DocumentMeta> getDocumentList() {
		return documentRepository.findAll();
	}

	public void addNewDocument(DocumentMeta document) {
		documentRepository.save(document);
		throw new IllegalStateException("Nikam test kare");
		//System.out.println(document);
	}

	public void deleteDocument(Long documentId) {
		if (!documentRepository.existsById(documentId)) {
			throw new IllegalStateException("No document associated with id : " + documentId);
		}
		documentRepository.deleteById(documentId);
	}
}
