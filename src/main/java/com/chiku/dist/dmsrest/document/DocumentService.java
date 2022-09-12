package com.chiku.dist.dmsrest.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

        if (text.equals("ALL") || text.equals("")) {
            return documentRepository.findAll();
        }

        System.out.println(text);
        String chunks[] = text.split("\\~");

        /**
         * 0 - Screen No = equals
         * 1 - file name = starts with
         * 2 - file type = pdf-1 , doc/docx-2, xls/xlsx-3
         * 3 - Object No = equals
         * 4 - date from = between from and to
         * 5 - date to   = between from and to
         * 6 - category = equals
         * 7 - subject  = starts with
         */

        List<Document> documents = documentRepository.findAll();

        if (!chunks[0].trim().equals("-1")) {
            //Screen number is set
            documents = documents.stream().filter(f -> f.getScreen().equals(chunks[0].trim())).toList();
        }

        if (!chunks[1].trim().equals("")) {
            //File name is set
            documents = documents.stream().filter(f -> f.getDocName().toLowerCase().startsWith(chunks[1].trim().toLowerCase())).toList();
        }

        if (!chunks[2].trim().equals("-1")) {
            //File type is set
            documents = switch (chunks[2].trim()) {
                case "1" ->
                    //pdf
                        documents.stream().filter(f -> f.getDocType().toLowerCase().equals("pdf")).toList();
                case "2" -> documents.stream().filter(f -> f.getDocType().toLowerCase().equals("doc")
                        || f.getDocType().toLowerCase().equals("docx")).toList();
                case "3" -> documents.stream().filter(f -> f.getDocType().toLowerCase().equals("xls")
                        || f.getDocType().toLowerCase().equals("xlsx")).toList();
                default -> documents;
            };
        }

        if (!chunks[3].trim().equals("")) {
            //Object Number is set
            documents = documents.stream().filter(f -> f.getObjectNumber().equals(chunks[3].trim())).toList();
        }

        if (!chunks[4].trim().equals("") && !chunks[5].trim().equals("")) {
            //Date from and To are set
            //documents = documents.stream().filter(f->f.getObjectNumber().equals(chunks[4].trim())).toList();
        }

        if (!chunks[7].trim().equals("")) {
            //Subject is set
            documents = documents.stream().filter(f->f.getSubject().toLowerCase().startsWith(chunks[7].trim().toLowerCase())).toList();
        }

        if (!chunks[8].trim().equals("")) {
            //Keywords are set
            documents = documents.stream().filter(f->f.getKeywords().toLowerCase().startsWith(chunks[8].trim().toLowerCase())).toList();
        }


//		return documentRepository.findAll().stream().filter(f -> f.getObjectNumber().equals(text)
//				|| f.getCategory().contains(text)
//				|| f.getDocName().contains(text)
//				|| f.getScreen().equals(text)
//				|| f.getSubject().contains(text)
//		).toList();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Customer");
        map.put(1, "Supplier");
        map.put(2, "Product");
        map.put(77, "Work Order");
        map.put(32, "Sales Order");
        map.put(35, "Sales Packing Slip");
        map.put(36, "Sales Invoice");
        map.put(42, "Purchase Order");
        map.put(45, "Purchasing Packing Slip");
        map.put(46, "Purchasing Invoice");
        map.put(143, "Lot");

        List<Document> docs = new ArrayList<>();
        for (Document doc : documents) {
            doc.setScreen(map.get(Integer.parseInt(doc.getScreen())));
            docs.add(doc);
        }
        return docs;
    }

    public List<Document> getDocumentListByTextAndType(String text, String type) {
        if ("objectType".equals(type)) {
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
