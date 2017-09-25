<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>心随笔</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/add.css">
  </head>
  
  <body>
    <div class="blog_content">
    <!-- blog_head -->
    	<div class="blog_head">
    	<div class="blog_head_left"></div>
    	<ul><li><a href="#">首页</a> | <a href="#">个人博客</a> | <a href="#" id="msg">新随笔</a> | <a href="#">留言板</a> | <a href="gotoAdminLogin.action">管理</a> | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    	<h2>新随笔></h2>
    	<hr>
    	<div class="container">
			<div class="public-content-cont">
			<form action="addinfo.action">
				<div class="form-group">
					<label for="">信息分类</label>
					<select name="category" class="form-input-txt">
						<option value="新闻">新闻</option>
						<option value="科技">科技</option>
					</select>
				</div>
				<div class="form-group">
					<label for="">信息标题</label>
					<input class="form-input-txt" type="text" name="title" value="" />
				</div>
			  <div class="form-group">
				<label for="">正文内容</label>
					<textarea id="editor_id" name="maintext"  class="form-input-textara" style="width:700px;height:300px;">
						
					</textarea> 
				</div>
				<s:iterator>
			  <div class="form-group">
					<label for="">发布人</label>
					<input class="form-input-txt" type="text" name="Introduced_person" value="<s:property value="#session.user_name"/>" readonly="readonly" />
				</div>
				</s:iterator>
				<div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</div>
			  </form>
			</div>
			
		</div>
		<hr>
		<h2>我的记录></h2>
		
		
			<div class="bottom">
	Copyright &copy; 2017.Company name All rights reserved.
</div>
		</div>
	
  </body>
</html>
