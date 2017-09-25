package com.hulin.service;

import java.util.List;

import Pagebean.PageBean;

import com.hulin.model.infomation_table;

public interface InfomationSevice  {

	public PageBean getPageBean(int pageSize, int page);
	
	public void addInfomation(infomation_table infomation);
	
}
