package com.hulin.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hulin.dao.userDAO;
import com.hulin.model.User;
import com.hulin.utils.HibrenateUtil;

public class userDAOImpl implements userDAO {

	@Override
	public void saveUser(User user) {
		//将对象保存到数据库
		
		//获取session
		Session session=HibrenateUtil.openSession();
		
		
		 //存取session
		
		Transaction tx= session.beginTransaction();
		
		try {
			//将person 对象保存到数据库中
			session.save(user);
			//处理事物
			tx.commit();
			
		} catch (Exception e) {
			if(null!=tx)
			{
				tx.rollback();
			}
			
		}finally{
			
			//关闭资源
			HibrenateUtil.close(session);
		}
	}

	@Override
	public List<User> listAllPerSons() {
		
		//1.获取session对象
				Session session=HibrenateUtil.openSession();
				//2
				Transaction tx= session.beginTransaction();
				//3
				List<User> list=null;
				try 
				{
					Query query=session.createQuery("from User");
					//HQL 有严格的大小写
					//查询的不是表的名字，是类的名字
					//如果出现重名，就要加上包的名字
					
					//将数据加入list
					list = (List<User>)query.list();
					
					tx.commit();
					
				} catch (Exception e) {
					if(null!=tx)
					{
						tx.rollback();
					}
				}
				finally
				{
					//关闭资源
					HibrenateUtil.close(session);
				}
				return list;
		
	}

	@Override
	public User getSinglePersonById(int id) {
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		User user=null;
		
		try {
			
			user=(User)session.get(User.class, id);
			
			tx.commit();
			
		} catch (Exception e) {
			if(null!=tx)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally
		{
			//关闭资源
			HibrenateUtil.close(session);
		}
		return user;
	}

	@Override
	public User CheckUser(String user_name, String user_pwd) {
		
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		User user=null;
		List<User> list=null;
		try {
			list=(List<User>)session.createQuery("from User where user_name='"+user_name+"' and user_pwd='"+user_pwd+"'").list();
			
			if(list!=null&&list.size()>0){
				user=list.get(0);
				 System.out.println("查询到的数据:"+user.toString());
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
		return user;
		
	}

	@Override
	public void updateUser(User user) {
		
		
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		try {
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			if(null!=tx)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally
		{
			//关闭资源
			HibrenateUtil.close(session);
		}
	}

}

