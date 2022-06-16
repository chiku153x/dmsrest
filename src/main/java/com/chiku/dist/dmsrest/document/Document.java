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
	private String instance;
	private String screen;
	private Long number;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kuala_Lumpur")
	private Date createdDate;
	private String docName;
	private String category;
	private String subject;
	private Long user;

	private String docType;

	public Document() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
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

	public Document(Long id, String instance, String screen, Long number, Date createdDate, String docName, String category, String subject, Long user, String docType) {
		Id = id;
		this.instance = instance;
		this.screen = screen;
		this.number = number;
		this.createdDate = createdDate;
		this.docName = docName;
		this.category = category;
		this.subject = subject;
		this.user = user;
		this.docType = docType;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Override
	public String toString() {
		return "Document{" +
				"Id=" + Id +
				", instance='" + instance + '\'' +
				", screen='" + screen + '\'' +
				", number=" + number +
				", createdDate=" + createdDate +
				", docName='" + docName + '\'' +
				", category='" + category + '\'' +
				", subject='" + subject + '\'' +
				", user=" + user +
				", docType='" + docType + '\'' +
				'}';
	}
}
