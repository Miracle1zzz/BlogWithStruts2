package com.hulin.dao;

import java.util.List;

import com.hulin.model.User;

public interface userDAO {
	
	//ע���û�
	public void saveUser(User user);
	//��ȡ�����û���Ϣ
	public List<User> listAllPerSons();
	//��id��ȡ�û���Ϣ
	public User getSinglePersonById(int id);
	
	//��֤�û���¼
	public User CheckUser(String user_name,String user_pwd);
	
	//�û���Ϣ�޸�
	
	public void updateUser(User user);

}
