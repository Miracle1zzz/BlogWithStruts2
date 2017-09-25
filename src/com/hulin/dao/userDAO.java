package com.hulin.dao;

import java.util.List;

import com.hulin.model.User;

public interface userDAO {
	
	//注册用户
	public void saveUser(User user);
	//获取所有用户信息
	public List<User> listAllPerSons();
	//按id获取用户信息
	public User getSinglePersonById(int id);
	
	//验证用户登录
	public User CheckUser(String user_name,String user_pwd);
	
	//用户信息修改
	
	public void updateUser(User user);

}
