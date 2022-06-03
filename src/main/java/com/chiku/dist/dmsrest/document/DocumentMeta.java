package com.chiku.dist.dmsrest.document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class DocumentMeta {
	@Id
	@SequenceGenerator(name = "document_sequence", sequenceName = "document_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "document_sequence")
	private Long Id;

	private String instance;
	private String screen;
	private String number;
	private String lineNo;
	private String fieldName;

	private Date createdDate;
	@Transient
	private Integer age;

	public DocumentMeta() {
		super();
	}

	public DocumentMeta(String instance, String screen, String number, String lineNo, String fieldName, Date createdDate) {
		this.instance = instance;
		this.screen = screen;
		this.number = number;
		this.lineNo = lineNo;
		this.fieldName = fieldName;
		this.createdDate = createdDate;
		this.age = age;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "DocumentMeta{" +
				"Id=" + Id +
				", instance='" + instance + '\'' +
				", screen='" + screen + '\'' +
				", number='" + number + '\'' +
				", lineNo='" + lineNo + '\'' +
				", fieldName='" + fieldName + '\'' +
				", createdDate=" + createdDate +
				", age=" + age +
				'}';
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
