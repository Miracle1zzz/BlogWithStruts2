package com.hulin.service;

import com.hulin.model.infomation_table_audit;

import Pagebean.PageBean;

public interface InfoListAuditService {
	public PageBean getPageBean(int pageSize, int page);
	
	public void addInfomation(infomation_table_audit table_audit);
	
	public void RemoveInfoBy(int id);
	
}
