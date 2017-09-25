package com.hulin.service.Impl;

import java.util.List;

import Pagebean.PageBean;

import com.hulin.dao.InfomationListDAO;
import com.hulin.dao.Impl.InfomationListDAOImpl;
import com.hulin.model.infomation_table;
import com.hulin.service.InfomationSevice;

public class InfomationServiceImpl implements InfomationSevice {

	private InfomationListDAO infomationListDAO=new InfomationListDAOImpl();
	
	@Override
	public PageBean getPageBean(int pageSize, int page) {
		
		
		PageBean pageBean = new PageBean();
        
        String hql = "from infomation_table";
        
        int allRows = infomationListDAO.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<infomation_table> list = infomationListDAO.ListAllInformation(hql, offset, pageSize);
          
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
    }

	@Override
	public void addInfomation(infomation_table infomation) {
		
		
		InfomationListDAO infomationListDAO=new InfomationListDAOImpl();
		
		infomationListDAO.addInfomation(infomation);
		
		
	}
		
}

