package com.hulin.dao;

import java.util.List;

import com.hulin.model.infomation_table_audit;

public interface InfoListAudit {
	
	public List<infomation_table_audit> ListInformation(String hql, int offset, int pageSize); 
	
	public int getAllRowCount(String hql);
	
	public void addInfomation(infomation_table_audit table_audit);
	
	public void RemoveInfoBy(int id);

}
