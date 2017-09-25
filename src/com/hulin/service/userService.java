package com.hulin.service;

import java.util.List;

import com.hulin.model.User;

public interface userService {
	
	public void saveUser(User user);
	
	public List<User> listAllPerSons();
	//按id获取用户信息
		public User getSinglePersonById(int id);
		
		//验证用户登录
		public User CheckUser(String user_name,String user_pwd);
		//用户信息修改
		
		public void updateUser(User user);
		

}
