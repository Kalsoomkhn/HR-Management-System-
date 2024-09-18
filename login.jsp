<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="first.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
    <br/> 
    <br/>
    <form action="login" method="post">
    <h1 style="text-align: center;">Authentication</h1><br/><br/>
   &nbsp; &nbsp; <label>Username</label>
   &nbsp; &nbsp; <input type="text" name="username" required><br/><br/>
   &nbsp; &nbsp; <label>Password</label>
   &nbsp; &nbsp; <input type="password" name="password" required><br/><br/><br/>
  &nbsp; &nbsp;  <button type="submit">Login</button>
  <br/>

      <%
        String match= DatabaseConnection.validateLog();
        if(match==null){
      %>
        &nbsp; &nbsp;  <button type="button" onclick="window.location.href='Register.jsp'" >Register</button>
      <% }%>
   <br/><br/>
  
    </form>

</body>
</html>