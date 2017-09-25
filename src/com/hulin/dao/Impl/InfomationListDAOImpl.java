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
			//�ر���Դ
			HibrenateUtil.close(session);
		}
		return allRows;
	}

	@Override
	public List<infomation_table> ListAllInformation(String hql, int offset,
			int pageSize) {
		//1.��ȡsession����
		Session session=HibrenateUtil.openSession();
		//2
		Transaction tx= session.beginTransaction();
		//3
		List<infomation_table> list=null;
		
		try {
			
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			//HQL ���ϸ�Ĵ�Сд
			//��ѯ�Ĳ��Ǳ�����֣����������
			//���������������Ҫ���ϰ�������
			
			//�����ݼ���list
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
			//�ر���Դ
			HibrenateUtil.close(session);
		}
		return list;
	}

	@Override
	public void addInfomation(infomation_table infomation) {
		//��ȡsession
				Session session=HibrenateUtil.openSession();
				
				
				 //��ȡsession
				
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
					
					//�ر���Դ
					HibrenateUtil.close(session);
				}
		
	}

}
