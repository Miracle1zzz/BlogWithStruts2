package com.hulin.action;

import java.util.Map;

import com.hulin.model.Admin;
import com.hulin.service.AdminService;
import com.hulin.service.Impl.AdminServiceImpl;
import com.hulin.service.Impl.userServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
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
	
	public String CheckAdmin() throws Exception
	{
		AdminService adminService=new AdminServiceImpl();
		
		Admin admin=adminService.CheckAdmin(admins_name, admins_pwd);
		
		Map session=ActionContext.getContext().getSession();
		
		if(admin!=null){
			session.put("id", admin.getId());
			session.put("admins_name", admin.getAdmins_name());
			return SUCCESS;
		}
		else{
			addFieldError("loginerror", "用户名或密码错误！");
			return INPUT;
		}
	}
	public String gotoAdminLogin() throws Exception
	{
		return SUCCESS;
	}
	public String gotoInfomation_table_audit() throws Exception
	{
		return SUCCESS;
	}

}
