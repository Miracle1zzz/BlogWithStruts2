package com.hulin.service.Impl;

import java.util.List;

import com.hulin.dao.userDAO;
import com.hulin.dao.Impl.userDAOImpl;
import com.hulin.model.User;
import com.hulin.service.userService;

public class userServiceImpl implements userService,userDAO {

	@Override
	public void saveUser(User user) {
		
		userDAO userdao=new userDAOImpl();
		userdao.saveUser(user);
		

	}

	@Override
	public List<User> listAllPerSons() {
		userDAO userdao=new userDAOImpl();
		return userdao.listAllPerSons();
	}

	@Override
	public User getSinglePersonById(int id) {
		userDAO userdao=new userDAOImpl();
		return userdao.getSinglePersonById(id);
	}

	@Override
	public User CheckUser(String user_name, String user_pwd) {
		userDAO userdao=new userDAOImpl();
		return userdao.CheckUser(user_name, user_pwd);
	}

	@Override
	public void updateUser(User user) {
		userDAO userdao=new userDAOImpl();
		userdao.updateUser(user);
		
	}

}
