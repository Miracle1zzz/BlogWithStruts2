<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <script language="javascript">
    function isRight(f){
  if(f.user_Id.value == "")
  {
     alert("注册名不能为空!");
	 return false;
   }
   else if(f.user_id.value.length>20)
   {
     alert("注册名必须小于20!");
	 return false;
   }
   else if((f.user_pwd.value.length<3)||(f.user_pwd.value.length>18))
   {
      alert("密码必须是大于3小于18的数字或字母!");
	  return false;
   }
  else if(f.user_pwd.value != f.user_pwd1.value)
  {
      alert("两次输入的密码不同!");
	  return false;
  }	
   else if((f.user_qq.value.length>15)||(f.user_qq.value.length<3))
   {
      alert("QQ号码必须大于3小于15!");
	  return false;
   }
  else if((f.user_email.value == "")||(f.user_email.value.indexOf('@',0) == -1)||(f.user_email.value.indexOf('.',0) == -1))
  {
      alert("请输入合法的邮箱地址!");
	  return false;
  }
  else
  { 
     return true;
   }
  
}
 </script>
  
  <body>
  	
  	<div class="loginwarrp">
		<div class="logo">新用户注册:（带'*'的内容必须填写）</div>
        <div class="login_form">
			<form action="userRegister" onkeyup="" onsubmit="return isRight(this);" >
				<li class="login-item">登 录 名:
					<input type="text" name="user_name" class="login_input">*
					<span id="msg1"></span>
				</li>
                <li class="login-item">密 码<span>：</span>
					<input type="password" name="user_pwd" class="login_input">*
				</li>
				<li class="login-item">密码确认<span>：</span>
					<input type="password" name="user_pwd1" class="login_input"/>*
				</li>
				<li class="login-item">性别<span>：</span>
					<input type="radio" name="user_sex" value="男" checked="checked" />男
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="user_sex" value="女"/>女
				</li>

				<li class="login-item">
					<span>Q Q：</span>
					<input type="text" name="user_qq" class="login_input"/>
				</li>
				<li class="login-item">
					邮箱地址<span>：</span>
					<input type="text" name="user_email" class="login_input"/>*
				</li>
				
			  <div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="确认" />
				</li>
                <div style="text-align:right;color:#ADADAD;"><a href="Login.jsp">返回登录?</a></div>                             
           </form>
		</div>
	</div>
  	
  	
  </body>
</html>
