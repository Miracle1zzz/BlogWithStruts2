package com.hulin.model;

import java.sql.Date;

public class infomation_table {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntroduced_person() {
		return introduced_person;
	}
	public void setIntroduced_person(String introduced_person) {
		this.introduced_person = introduced_person;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMaintext() {
		return maintext;
	}
	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}
	private String introduced_person;
	private String introduced_date;
	public String getIntroduced_date() {
		return introduced_date;
	}
	public void setIntroduced_date(String introduced_date) {
		this.introduced_date = introduced_date;
	}
	private String category;
	private String title;
	private String maintext;

}
