package com.chiku.dist.dmsrest.screens;

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

	public Screen() {
		super();
	}

	public Screen(Long id, Long screenNumber, String screenName) {
		Id = id;
		this.screenNumber = screenNumber;
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Screen{" +
				"Id=" + Id +
				", screenNumber=" + screenNumber +
				", screenName='" + screenName + '\'' +
				'}';
	}
}
