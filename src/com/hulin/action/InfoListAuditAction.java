package com.hulin.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Pagebean.PageBean;

import com.hulin.model.infomation_table;
import com.hulin.model.infomation_table_audit;
import com.hulin.service.InfoListAuditService;
import com.hulin.service.InfomationSevice;
import com.hulin.service.Impl.InfoListAuditServiceImpl;
import com.hulin.service.Impl.InfomationServiceImpl;
import com.hulin.utils.Tools;
import com.opensymphony.xwork2.ActionSupport;

public class InfoListAuditAction extends ActionSupport {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntroduced_person() {
		return introduced_person;
	}
	public void setIntroduced_person(String introduced_person) {
		this.introduced_person = introduced_person;
	}
	public String getIntroduced_date() {
		return introduced_date;
	}
	public void setIntroduced_date(String introduced_date) {
		this.introduced_date = introduced_date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMaintext() {
		return maintext;
	}
	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}
	private int id;
	private String introduced_person;
	private String introduced_date;
	private String category;
	private String title;
	private String maintext;
	
	private InfoListAuditService auditService=new InfoListAuditServiceImpl();
	
	private int page;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String InfoList() throws Exception
	{
		//表示每页显示6条记录，page表示当前网页
        PageBean pageBean = auditService.getPageBean(6, page);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        request.setAttribute("pageBean", pageBean);
        
        return SUCCESS;
	}
	public String addInfo() throws Exception
	{
		infomation_table_audit table_audit=new infomation_table_audit();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.sql.Date registerDate=new java.sql.Date(new java.util.Date().getTime());
		String introduced_date=sdf.format(registerDate);
		table_audit.setCategory(Tools.toChinese(category));
		table_audit.setIntroduced_date(introduced_date);
		table_audit.setIntroduced_person(Tools.toChinese(introduced_person));
		table_audit.setMaintext(Tools.toChinese(maintext));
		table_audit.setTitle(Tools.toChinese(title));
		
		InfoListAuditService auditService=new InfoListAuditServiceImpl();
		
		auditService.addInfomation(table_audit);
		
		
		
		return SUCCESS;
		
	}
	
	public String RemoveInfo() throws Exception
	{
		InfoListAuditService auditService=new InfoListAuditServiceImpl();
		
		auditService.RemoveInfoBy(id);
		//表示每页显示6条记录，page表示当前网页
        PageBean pageBean = auditService.getPageBean(6, page);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	public String gotoAdpass() throws Exception
	{
		return SUCCESS;
	}

}
