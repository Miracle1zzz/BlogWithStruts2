<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

       <title>HL博客后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#9AE4E8">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>HL博客后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="gotoAdminLogin.action"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="gotoAdpass.action" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="gotoInfomation_table_audit.action" target="right"><span class="icon-caret-right"></span>博客管理</a></li>  
    <li><a href="infomationList.action" target="right"><span class="icon-caret-right"></span>博客首页</a></li>   
    <li><a href="#" target="right"><span class="icon-caret-right"></span>留言管理</a></li>     
    <li><a href="#" target="right"><span class="icon-caret-right"></span>公告管理</a></li>
  </ul>   
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="infomationList.action" name="right" width="100%" height="100%"></iframe>
</div>
  </body>
</html>
