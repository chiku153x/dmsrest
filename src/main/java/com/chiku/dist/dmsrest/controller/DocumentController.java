package com.chiku.dist.dmsrest.controller;

import com.chiku.dist.dmsrest.dto.DocumentDto;
import com.chiku.dist.dmsrest.service.DocumentService;
import com.chiku.dist.dmsrest.model.Document;
import com.chiku.dist.dmsrest.model.Permission;
import com.chiku.dist.dmsrest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/document")
public class DocumentController {

    private final DocumentService documentService;
    private final PermissionService permissionService;


    @Autowired
    public DocumentController(DocumentService documentService, PermissionService permissionService) {
        this.documentService = documentService;
        this.permissionService = permissionService;
    }


    @PostMapping(path = "/related/{number}")
    public ResponseEntity getDocumentList(@PathVariable("number") String number, @RequestBody DocumentDto documentVo) {
        Map<String,String> message = new HashMap<>();

        List<Permission> permissions = permissionService.getPermissionsByUserNameAndScreenNo(documentVo.getUser(), documentVo.getScreen());
        if (permissions.isEmpty()) {
            message.put("message","No permission");
            return new ResponseEntity(message,HttpStatus.OK);
        }
        return new ResponseEntity(documentService.getDocumentList(number),HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public void createDocument(@RequestBody Document document, @RequestHeader("token") String token) {
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

    @GetMapping(path = "/search/{text}")
    public Map<String, List<String[]>> getDocumentListByFullText(@PathVariable("text") String text) {
        Map<String, List<String[]>> data = new HashMap<>();
        final List<Document> dataFromDb = documentService.getDocumentListByFullText(text.trim());
        List<String[]> finalDataList = new ArrayList<>();
        int i = 0;
        for (Document doc : dataFromDb) {
            i++;
            String str[] = new String[9];
            str[0] = i + "";
            str[1] = doc.getObjectNumber();
            str[2] = doc.getScreen();
            str[3] = doc.getCategory();
            str[4] = doc.getSubject();
            str[5] = doc.getDocName();
            str[6] = doc.getCreatedDate().toString();
            str[7] = doc.getKeywords();
            str[8] = "<span onClick='docView(\"" + doc.getDir()+  "\",\"" + doc.getDocName() + "\")' class='actions'>view</span>";

            finalDataList.add(str);
        }
        data.put("data", finalDataList);
        return data;
    }
}

