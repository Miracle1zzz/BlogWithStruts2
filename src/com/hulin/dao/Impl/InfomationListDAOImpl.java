package com.hulin.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hulin.dao.InfomationListDAO;
import com.hulin.model.infomation_table;
import com.hulin.utils.HibrenateUtil;


public class InfomationListDAOImpl implements InfomationListDAO {

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
	public List<infomation_table> ListAllInformation(String hql, int offset,
			int pageSize) {
		//1.获取session对象
		Session session=HibrenateUtil.openSession();
		//2
		Transaction tx= session.beginTransaction();
		//3
		List<infomation_table> list=null;
		
		try {
			
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			//HQL 有严格的大小写
			//查询的不是表的名字，是类的名字
			//如果出现重名，就要加上包的名字
			
			//将数据加入list
			list = (List<infomation_table>)query.list();
			
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
	public void addInfomation(infomation_table infomation) {
		//获取session
				Session session=HibrenateUtil.openSession();
				
				
				 //存取session
				
				Transaction tx= session.beginTransaction();
				
				try {
					
					session.save(infomation);
					
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

}
