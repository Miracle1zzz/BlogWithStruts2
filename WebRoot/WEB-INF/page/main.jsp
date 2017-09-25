<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
    <div class="blog_content">
    <!-- blog_head -->
    	<div class="blog_head">
    	<div class="blog_head_left"></div>
    	<ul><li><a href="#">首页</a> | <a href="infomationList.action">个人博客</a> | <a href="gotoAddMessage.action" id="msg">新随笔</a> | <a href="#">留言板</a> | <a href="gotoAdminLogin.action">管理</a> | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	| 
    	<s:if test="%{#session.user_name !=null}">
    	
    	用户&nbsp;<s:a href="updateUser.action?id=%{#session.id}"><s:property value="#session.user_name"/></s:a>&nbsp;您好！
    	
    	</s:if>
    	<s:if test="%{#session.user_name==null}">
    	
    	<a href="Login.jsp">登录</a> &nbsp;<a href="register.jsp">注册</a></s:if></li></ul>
    	
    	<div class="blog_head_right">
    	<form action="" name="search">
		<input name="search" type="text" value="搜索关键词:" size="20" onMouseOver="this.select()" class="search"> 
		
		<input type="submit" name="sub-btn" value="搜索" class="sub-btn">
		
		</form> 
    	</div>
    	</div>
    	<!-- end -->
    	
    	<!-- title -->
    	<div class="blog_head2"><h1>HL(blog)博客<br />每一个成功者都有一个开始;勇于开始，才能找到成功的路.</h1></div>
    	<!-- end -->
    	
    	<!-- content -->
    	<div class="content">
    	<ul>
    		<li><p>我的文档 > 首页</p></li>
    		</ul>
    	<s:iterator value="#request.pageBean.list" var="person">
    		<div class="content_left">
    		<ul>
			  <li>
			  <strong><a href="#"><s:property value="#person.title"/></a></strong>
			  </li>
			  <li><span><s:property value="#person.maintext"/></span>
			  </li> 
			  <li><font>发布于 <s:property value="#person.introduced_date"/> 
			  <a>查看</a>(98) 
			  <span>收藏</span> | <a>分享</a> | 分类:<a><s:property value="#person.category"/></a> <a>作者:<s:property value="#person.introduced_person"/> </a> </font>
			  </li>
			  <li>
			  </li>
			  <li>
			  <hr>
			  </li>
    		</ul>
    		</div>
    		</s:iterator>
    		<div class="content_right">
    		
    		<ul>
			  <li><br /><img src="image/person.gif" width="128" height="128" /></li>
				<li><h2>公告</h2></li> 
				<li><p><a href="#">Seo知识</a></p></li>
				 <li><p><a href="#">seo技巧</a></p></li> 
				 <li><p><a href="#">seo工具</a></p></li>
				<li><h2>最新文章</h2></li>
				<li><p><a href="#">关键字与搜索引擎营销</a></p></li>
				<li><p><a href="#">让你的网站讨好搜索引擎的方法</a></p></li>
				<li><p><a href="#">怎样避免被搜索引擎视为作弊?</a></p></li>
				<li><p><a href="#">优化框架型网页的技巧</a></p></li>
				<li><p><a href="#">seo的作用</a></p></li>
				<li><p><a href="#">五个seo报价参考方案</a></p></li>
				<li><p><a href="#">网站改版SEO应该注意的问题</a></p></li>
				<li><p><a href="#">搜索引擎关键词排名优化技巧</a></p></li>
				<li><p><a href="#">网站优化实用技术问答</a></p></li>
				<li><p><a href="#">百度收录减少的原因和解决办法</a></p></li>
				<li><h2>友情链接</h2></li>
				
			  </ul>
    		</div>
    	
    	</div>
    	<!-- end -->
    	 <center>
    
        <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>
        
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="infomationList.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="infomationList.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="infomationList.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="infomationList.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    <!--  
    <center>
        
        <form action="InfomationAction.action" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
        
    </center>-->
    	<div class="bottom"><ul><li>Copyright &copy; 2017.Company name All rights reserved.</li></ul></div>
    </div>
  </body>
</html>
