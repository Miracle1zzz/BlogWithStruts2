package com.hulin.service.Impl;

import com.hulin.dao.AdminDAO;
import com.hulin.dao.Impl.AdminDAOImpl;
import com.hulin.model.Admin;
import com.hulin.service.AdminService;

public class AdminServiceImpl implements AdminService, AdminDAO {

	@Override
	public Admin CheckAdmin(String admins_name, String admins_pwd) {
	
		AdminDAO adminDAO=new AdminDAOImpl();
		
		return adminDAO.CheckAdmin(admins_name, admins_pwd);
		
	}

}
