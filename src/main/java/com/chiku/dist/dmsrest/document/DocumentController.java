package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/document")
public class DocumentController {

	private final DocumentService documentService;

	@Autowired
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}


	@GetMapping(path = "/related/{number}")
	public List<Document> getDocumentList(@PathVariable("number") Long number) {
		return documentService.getDocumentList(number);
	}

	@PostMapping(path = "/add")
	public void createDocument(@RequestBody Document document) {
		documentService.addNewDocument(document);
	}

//	@DeleteMapping(path = "/{documentId}")
//	public void deleteDocument(@PathVariable("documentId") Long documentId) {
//		documentService.deleteDocument(documentId);
//	}
//
//	@PutMapping(path="/{documentId}")
//	public void updateDocument(){
//
//	}
}
