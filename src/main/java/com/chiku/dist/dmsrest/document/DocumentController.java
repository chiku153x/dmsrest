package com.chiku.dist.dmsrest.document;

import com.chiku.dist.dmsrest.permission.Permission;
import com.chiku.dist.dmsrest.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity getDocumentList(@PathVariable("number") String number, @RequestBody DocumentVO documentVo) {
        List<Permission> permissions = permissionService.getPermissionsByUserNameAndScreenNo(documentVo.getUser(), documentVo.getScreen(), documentVo.getInstance());
        if (permissions.isEmpty()) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(documentService.getDocumentList(number),HttpStatus.OK);
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

    @GetMapping(path = "/search/{text}")
    public Map<String, List<String[]>> getDocumentListByFullText(@PathVariable("text") String text) {
        Map<String, List<String[]>> data = new HashMap<>();
        final List<Document> dataFromDb = documentService.getDocumentListByFullText(text.trim());
        List<String[]> finalDataList = new ArrayList<>();
        int i = 0;
        for (Document doc : dataFromDb) {
            i++;
            String str[] = new String[8];
            str[0] = i + "";
            str[1] = doc.getObjectNumber();
            str[2] = doc.getScreen();
            str[3] = doc.getCategory();
            str[4] = doc.getSubject();
            str[5] = doc.getDocName();
            str[6] = doc.getCreatedDate().toString();

            //instance,screen,number,docName
            //str[7] = "<span onClick='docView(\"" +doc.getInstance()+ "\",\""+doc.getScreen()+"\",\""+doc.getNumber()+"\",\""+doc.getDocName()+"\")' class='actions'>View</span> | <span onClick='docDownload(\""+doc.getNumber()+"\")' class='actions'>Download</span>";
            str[7] = "<span onClick='docView(\"" + doc.getDir()+  "\",\"" + doc.getDocName() + "\")' class='actions'>view</span>";

            finalDataList.add(str);
        }
        data.put("data", finalDataList);
        return data;
    }
}

