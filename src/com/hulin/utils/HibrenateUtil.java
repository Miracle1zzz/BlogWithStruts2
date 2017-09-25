package com.hulin.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibrenateUtil {
	
private static SessionFactory sessionFactory;
	
	static{
		
		try {
			
			  Configuration config = new Configuration();
		        config.configure();
		        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		        sessionFactory = config.buildSessionFactory(serviceRegistry);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//创建session
	public static Session openSession()
	{
		Session session=sessionFactory.openSession();
		return session;
	}
	
	//关闭资源
	
	public static void close(Session session)
	{
		if(null!=session)
		{
			session.close();
		}
	}
}
