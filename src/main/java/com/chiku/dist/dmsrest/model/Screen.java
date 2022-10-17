package com.chiku.dist.dmsrest.model;

import javax.persistence.*;

@Entity
@Table
public class Screen {
	@javax.persistence.Id
	@SequenceGenerator(name = "screen_sequence", sequenceName = "screen_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "screen_sequence")
	private Long Id;
	private Long screenNumber;
	private String screenName;
	private String module;


	public Screen() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getScreenNumber() {
		return screenNumber;
	}

	public void setScreenNumber(Long screenNumber) {
		this.screenNumber = screenNumber;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}




	public Screen(Long id, Long screenNumber, String screenName, String module) {
		Id = id;
		this.screenNumber = screenNumber;
		this.screenName = screenName;
		this.module = module;

	}

	@Override
	public String toString() {
		return "Screen{" +
				"Id=" + Id +
				", screenNumber=" + screenNumber +
				", screenName='" + screenName + '\'' +
				", module='" + module + '\'' +
				'}';
	}
}
