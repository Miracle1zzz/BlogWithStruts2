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
		//�����󱣴浽���ݿ�
		
		//��ȡsession
		Session session=HibrenateUtil.openSession();
		
		
		 //��ȡsession
		
		Transaction tx= session.beginTransaction();
		
		try {
			//��person ���󱣴浽���ݿ���
			session.save(user);
			//��������
			tx.commit();
			
		} catch (Exception e) {
			if(null!=tx)
			{
				tx.rollback();
			}
			
		}finally{
			
			//�ر���Դ
			HibrenateUtil.close(session);
		}
	}

	@Override
	public List<User> listAllPerSons() {
		
		//1.��ȡsession����
				Session session=HibrenateUtil.openSession();
				//2
				Transaction tx= session.beginTransaction();
				//3
				List<User> list=null;
				try 
				{
					Query query=session.createQuery("from User");
					//HQL ���ϸ�Ĵ�Сд
					//��ѯ�Ĳ��Ǳ�����֣����������
					//���������������Ҫ���ϰ�������
					
					//�����ݼ���list
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
					//�ر���Դ
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
			//�ر���Դ
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
				 System.out.println("��ѯ��������:"+user.toString());
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
			//�ر���Դ
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
			//�ر���Դ
			HibrenateUtil.close(session);
		}
	}

}

