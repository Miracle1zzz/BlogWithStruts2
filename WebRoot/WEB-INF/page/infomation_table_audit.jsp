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
   <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
     
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th>作者</th>       
        <th>文章类别</th>
        <th>主题</th>
        <th>上传时间</th>
        <th>操作</th>       
      </tr>
      <s:iterator value="#request.pageBean.list_audit" var="infolist">      
        <tr>
          <td><input type="checkbox" name="id[]" value="1" />
            <s:property value="#infolist.id"/></td>
          <td><s:property value="#infolist.introduced_person"/></td>
          <td><s:property value="#infolist.category"/></td>
          <td><s:property value="#infolist.title"/></td>  
           <td><s:property value="#infolist.introduced_date"/></td>
           <td><div class="button-group"> <s:a class="button border-red" href="addInfomation.action?introduced_person=%{#infolist.introduced_person}&category=%{#infolist.category}&title=%{#infolist.title}&maintext=%{#infolist.maintext}&id=%{#infolist.id}"><span class="icon-trash-o"></span> 通过</s:a> </div>   
          <div class="button-group"> <s:a class="button border-red" href="deleteInfo.action?id=%{#infolist.id}"><span class="icon-trash-o"></span> 删除</s:a> </div></td>
        </tr>
         </s:iterator>
    
    </table>
   
  </div>
</form>
  </body>
</html>
