package com.hulin.dao;

import java.util.List;

import com.hulin.model.infomation_table;

public interface InfomationListDAO {
	
	public List<infomation_table> ListAllInformation(String hql, int offset, int pageSize); 
	
	public int getAllRowCount(String hql);
	
	public void addInfomation(infomation_table infomation);
	

}
