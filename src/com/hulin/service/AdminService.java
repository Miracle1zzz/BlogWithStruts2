package com.hulin.service;

import com.hulin.model.Admin;

public interface AdminService {
	//验证用户登录
			public Admin CheckAdmin(String admins_name,String admins_pwd);


}
