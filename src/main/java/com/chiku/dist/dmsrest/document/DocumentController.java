package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/document")
public class DocumentController {

	private final DocumentService documentService;

	@Autowired
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	@GetMapping(path = "/getdocumentList")
	public List<DocumentMeta> getDocumentList() {
		return documentService.getDocumentList();
	}

	@PostMapping(path = "addDocument")
	public void createDocument(@RequestBody DocumentMeta document) {
		documentService.addNewDocument(document);
	}

	@DeleteMapping(path = "{documentId}")
	public void deleteDocument(@PathVariable("documentId") Long documentId) {
		documentService.deleteDocument(documentId);
	}

	@PutMapping(path="{documentId}")
	public void updateDocument(){

	}
}
