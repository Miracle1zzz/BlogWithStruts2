package com.hulin.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hulin.dao.InfoListAudit;
import com.hulin.model.infomation_table;
import com.hulin.model.infomation_table_audit;
import com.hulin.utils.HibrenateUtil;

public class InfoListAuditDAOImpl implements InfoListAudit {

	@Override
	public List<infomation_table_audit> ListInformation(String hql, int offset,
			int pageSize) {
		//1.获取session对象
				Session session=HibrenateUtil.openSession();
				//2
				Transaction tx= session.beginTransaction();
				//3
				List<infomation_table_audit> list=null;
				
				try {
					
					Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
					//HQL 有严格的大小写
					//查询的不是表的名字，是类的名字
					//如果出现重名，就要加上包的名字
					
					//将数据加入list
					list = (List<infomation_table_audit>)query.list();
					
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
	public int getAllRowCount(String hql) {
		Session session = HibrenateUtil.openSession();
        Transaction tx = null;
        int allRows = 0;
        try {
        	tx = session.beginTransaction();
            
            Query query = session.createQuery(hql);
            
            allRows = query.list().size();
            
            tx.commit();
		} catch (Exception e) {
			if(tx != null)
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
		return allRows;
	}

	@Override
	public void addInfomation(infomation_table_audit table_audit) {
		//获取session
		Session session=HibrenateUtil.openSession();
		
		
		 //存取session
		
		Transaction tx= session.beginTransaction();
		
		try {
			
			session.save(table_audit);
			
			tx.commit();
			
		} catch (Exception e) {
			
			if(null!=tx)
			{
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally{
			
			//关闭资源
			HibrenateUtil.close(session);
		}

	}

	@Override
	public void RemoveInfoBy(int id) {
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		try 
		{
			//执行查询操作
			infomation_table_audit table_audit=(infomation_table_audit)session.get(infomation_table_audit.class, id);
			//删除查询到的对象
			session.delete(table_audit);
			
			//提交事物
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
		
		
	}

}
