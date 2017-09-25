package com.hulin.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hulin.model.User;
import com.hulin.service.userService;
import com.hulin.service.Impl.userServiceImpl;
import com.hulin.utils.Tools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userAction extends ActionSupport{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_qq() {
		return user_qq;
	}
	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	private String user_name;
	private String user_pwd;
	private String user_sex;
	private String user_qq;
	private String user_email;
	
	public String saveUser() throws Exception
	{
		User user=new User();
		
		user.setUser_name(user_name);
		user.setUser_pwd(user_pwd);
		user.setUser_sex(Tools.toChinese(user_sex));
		user.setUser_qq(user_qq);
		user.setUser_email(user_email);
		
		userService service=new userServiceImpl();
		
		service.saveUser(user);
		
		//提取数据
		List<User> list=service.listAllPerSons();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("list", list);
		
		return SUCCESS;
	}
	public String getSinglePersonById() throws Exception
	{
		userService userservice=new userServiceImpl();
		
		User user=userservice.getSinglePersonById(id);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("user", user);
		
		return SUCCESS;
	}
	//验证用户登录信息，并保存相应的用户名
	public String CheckUser() throws Exception
	{
		userService userservice=new userServiceImpl();
		
		User user=userservice.CheckUser(user_name, user_pwd);
		
		Map session=ActionContext.getContext().getSession();
		
		if(user!=null){
			session.put("id", user.getId());
			session.put("user_name", user.getUser_name());
			return SUCCESS;
		}
		else{
			addFieldError("loginerror", "用户名或密码错误！");
			return INPUT;
		}
	}
	
	//
	
	public String updateUser() throws Exception
	{
		userService userservice=new userServiceImpl();
		
		User user=userservice.getSinglePersonById(id);
		
		user.setUser_pwd(user_pwd);
		user.setUser_name(user_name);
		user.setUser_sex(user_sex);
		user.setUser_email(user_email);
		user.setUser_qq(user_qq);
		
		userservice.updateUser(user);
		
		return SUCCESS;
	}
	

}
