package com.hulin.service.Impl;

import java.util.List;

import Pagebean.PageBean;

import com.hulin.dao.InfoListAudit;
import com.hulin.dao.Impl.InfoListAuditDAOImpl;
import com.hulin.model.infomation_table;
import com.hulin.model.infomation_table_audit;
import com.hulin.service.InfoListAuditService;

public class InfoListAuditServiceImpl implements InfoListAuditService {

	
	private InfoListAudit infoListAudit=new InfoListAuditDAOImpl();
	@Override
	public PageBean getPageBean(int pageSize, int page) {
		
		
		PageBean pageBean = new PageBean();
        
        String hql = "from infomation_table_audit";
        
        int allRows = infoListAudit.getAllRowCount(hql);
        
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = pageBean.getCurPage(page);
        
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<infomation_table_audit> list_audit = infoListAudit.ListInformation(hql, offset, pageSize);
          
        pageBean.setList_audit(list_audit);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        
        return pageBean;
	}
	@Override
	public void addInfomation(infomation_table_audit table_audit) {
		
		InfoListAudit infoListAudit=new InfoListAuditDAOImpl();
		
		infoListAudit.addInfomation(table_audit);
		
		
	}
	@Override
	public void RemoveInfoBy(int id) {
		InfoListAudit infoListAudit=new InfoListAuditDAOImpl();
		infoListAudit.RemoveInfoBy(id);
		
	}

}
