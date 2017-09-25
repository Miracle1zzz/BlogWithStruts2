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
		//1.��ȡsession����
				Session session=HibrenateUtil.openSession();
				//2
				Transaction tx= session.beginTransaction();
				//3
				List<infomation_table_audit> list=null;
				
				try {
					
					Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
					//HQL ���ϸ�Ĵ�Сд
					//��ѯ�Ĳ��Ǳ�����֣����������
					//���������������Ҫ���ϰ�������
					
					//�����ݼ���list
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
					//�ر���Դ
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
			//�ر���Դ
			HibrenateUtil.close(session);
		}
		return allRows;
	}

	@Override
	public void addInfomation(infomation_table_audit table_audit) {
		//��ȡsession
		Session session=HibrenateUtil.openSession();
		
		
		 //��ȡsession
		
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
			
			//�ر���Դ
			HibrenateUtil.close(session);
		}

	}

	@Override
	public void RemoveInfoBy(int id) {
		Session session=HibrenateUtil.openSession();
		
		Transaction tx= session.beginTransaction();
		
		try 
		{
			//ִ�в�ѯ����
			infomation_table_audit table_audit=(infomation_table_audit)session.get(infomation_table_audit.class, id);
			//ɾ����ѯ���Ķ���
			session.delete(table_audit);
			
			//�ύ����
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
		
		
	}

}
