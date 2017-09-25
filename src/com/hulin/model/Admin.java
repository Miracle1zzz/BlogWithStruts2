package com.hulin.model;

public class Admin {
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmins_name() {
		return admins_name;
	}

	public void setAdmins_name(String admins_name) {
		this.admins_name = admins_name;
	}

	public String getAdmins_pwd() {
		return admins_pwd;
	}

	public void setAdmins_pwd(String admins_pwd) {
		this.admins_pwd = admins_pwd;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getAdmins_level() {
		return admins_level;
	}

	public void setAdmins_level(String admins_level) {
		this.admins_level = admins_level;
	}

	private String admins_name;
	
	private String  admins_pwd;
	
	private String add_date;
	
	private String admins_level;

}
