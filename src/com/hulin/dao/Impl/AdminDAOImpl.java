package com.hulin.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hulin.dao.AdminDAO;
import com.hulin.model.Admin;
import com.hulin.utils.HibrenateUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin CheckAdmin(String admins_name, String admins_pwd) {
		
		
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		Admin admin=null;
		List<Admin> list=null;
		try {
			list=(List<Admin>)session.createQuery("from Admin where admins_name='"+admins_name+"' and admins_pwd='"+admins_pwd+"'").list();
			
			if(list!=null&&list.size()>0){
				admin=list.get(0);
				 System.out.println("查询到的数据:"+admin.toString());
			}
			
			tx.commit();
			
		} catch (Exception e) {

			if(null!=tx)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			//关闭资源
			HibrenateUtil.close(session);
		}
		return admin;
	}

}
