package com.hulin.dao;

import com.hulin.model.Admin;;

public interface AdminDAO {
	//验证用户登录
		public Admin CheckAdmin(String admins_name,String admins_pwd);

}
