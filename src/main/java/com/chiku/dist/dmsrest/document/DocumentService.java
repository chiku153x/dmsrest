package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

	public List<Document> getDocumentList(String number) {
		return documentRepository.findAll().stream().filter(f -> f.getNumber().equals(number)).toList();
	}

	public List<Document> getDocumentListByFullText(String text) {

		if(text.equals("ALL") || text.equals("")){
			return documentRepository.findAll();
		}

		return documentRepository.findAll().stream().filter(f -> f.getObjectNumber().equals(text)
				|| f.getCategory().contains(text)
				|| f.getDocName().contains(text)
				|| f.getScreen().equals(text)
				|| f.getSubject().contains(text)
		).toList();
	}

	public List<Document> getDocumentListByTextAndType(String text, String type) {
		switch (type) {
			case "objectType":
				return documentRepository.findAll().stream().filter(f -> f.getScreen().equals(text)
				).collect(Collectors.toList());
		}
		return documentRepository.findAll().stream().filter(f -> f.getObjectNumber().equals(text)
				|| f.getCategory().contains(text)
				|| f.getDocName().contains(text)
				|| f.getScreen().equals(text)
				|| f.getSubject().contains(text)
		).toList();
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
