package com.chiku.dist.dmsrest.document;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Document {
	@Id
	@SequenceGenerator(name = "document_sequence", sequenceName = "document_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "document_sequence")
	private Long Id;

	private String screen;
	private String number;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kuala_Lumpur")
	private Date createdDate;
	private String docName;
	private String category;
	private String subject;
	private Long user;

	private String docType;

	private String objectNumber;

	private String dir;

	private String keywords;

	public Document() {
		super();
	}

	public Document(Long id, String screen, String number, Date createdDate, String docName, String category, String subject, Long user, String docType, String objectNumber, String dir, String keywords) {
		Id = id;
		this.screen = screen;
		this.number = number;
		this.createdDate = createdDate;
		this.docName = docName;
		this.category = category;
		this.subject = subject;
		this.user = user;
		this.docType = docType;
		this.objectNumber = objectNumber;
		this.dir = dir;
		this.keywords = keywords;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getObjectNumber() {
		return objectNumber;
	}

	public void setObjectNumber(String objectNumber) {
		this.objectNumber = objectNumber;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}

