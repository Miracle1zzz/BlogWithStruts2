package com.hulin.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Pagebean.PageBean;

import com.hulin.service.InfoListAuditService;
import com.hulin.service.InfomationSevice;
import com.hulin.service.Impl.InfoListAuditServiceImpl;
import com.hulin.service.Impl.InfomationServiceImpl;
import com.hulin.utils.Tools;

import com.hulin.model.infomation_table;
import com.opensymphony.xwork2.ActionSupport;

public class InfomationAction extends ActionSupport {
	
	private int id;
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
	private String introduced_person;
	private String introduced_date;
	private String category;
	private String title;
	private String maintext;
	
	private InfomationSevice infomationSevice=new InfomationServiceImpl();
	
	 private int page;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String InfomationList() throws Exception
	{
		//表示每页显示5条记录，page表示当前网页
        PageBean pageBean = infomationSevice.getPageBean(6, page);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        
        request.setAttribute("pageBean", pageBean);
        
        return SUCCESS;
	}
	
	public String addInfomation() throws Exception
	{
		infomation_table infomation=new infomation_table();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.sql.Date registerDate=new java.sql.Date(new java.util.Date().getTime());
		String introduced_date=sdf.format(registerDate);
		infomation.setCategory(Tools.toChinese(category));
		infomation.setIntroduced_date(introduced_date);
		infomation.setIntroduced_person(Tools.toChinese(introduced_person));
		infomation.setMaintext(Tools.toChinese(maintext));
		infomation.setTitle(Tools.toChinese(title));
		
		InfomationSevice sevice=new InfomationServiceImpl();
		
		sevice.addInfomation(infomation);
		
		InfoListAuditService auditService=new InfoListAuditServiceImpl();
		auditService.RemoveInfoBy(id);
		 PageBean pageBean = auditService.getPageBean(6, page);
	        
	        HttpServletRequest request = ServletActionContext.getRequest();
	        
	        request.setAttribute("pageBean", pageBean);
		
		return SUCCESS;
		
	}
	public String gotoAddMessage() throws Exception
	{
		return SUCCESS;
	}

}
