<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <base href="<%=basePath%>">

  <title>修改密码</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="stylesheet" type="text/css" href="/css/style.css">
  <script type="text/javascript" src="/js/lib/jquery.min.js"></script>
  <script type="text/javascript" src="/js/lib/jquery.validate.min.js"></script>
  <script type="text/javascript" src="/js/lib/md5.js"></script>
  <script type="text/javascript" src="/js/modifypw.js"></script>
  <style>
.error {
	color: red;
	font-style: italic;
}
</style>
 </head>

 <body>
  <div id="wrap">
   <div id="top_content">
    <div id="header">
     <div id="rightheader">
     </div>
     <div id="topheader">
      <h1 id="title">
      </h1>
     </div>
     <div id="navigation">
     </div>
    </div>
    <div id="content">
     <p id="whereami">
     </p>
     <h1>修改密码  </h1>
     <form action="/login.php" method="post">
      <table cellpadding="0" cellspacing="0" border="0" class="form_table">
       <tbody>
        <tr>
         <td valign="middle" align="right">
          旧密码:
         </td>
         <td valign="middle" align="left">
          <input type="password" class="inputgri" name="oldpw" id="oldpw">
         </td>
        </tr>
        <tr>
         <td valign="middle" align="right">
          新密码:
         </td>
         <td valign="middle" align="left">
          <input type="password" class="inputgri" name="pw1" id="newpw">
         </td>
        </tr>
        <tr>
         <td valign="middle" align="right">
          确认密码:
         </td>
         <td valign="middle" align="left">
          <input type="password" class="inputgri" name="pw2" id="pw2">
         </td>
        </tr>
       </tbody>
      </table>
      <p>
       <input type="submit" class="button" value="确认" />
       <input type="button" class="button" value="返回" onclick="window.location.href='queryuserlist.php';">
      </p>
     </form>
    </div>
   </div>
   <div id="footer">
    <div id="footer_bg">
    </div>
   </div>
  </div>
 </body>
</html>
