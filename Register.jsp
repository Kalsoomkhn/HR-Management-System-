<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Registration</title>
</head>
<body> 
<h1 style="text-align: center;">New Employee Registration</h1><br/><br/>
<form action="register" method="post">

&nbsp; &nbsp;&nbsp; &nbsp;<label>User Name</label>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="username" required><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Password</label>&nbsp; &nbsp;
&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input type="password" name="password" required><br/><br/>
<br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Select Gender</label><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="radio" name="Gender" value="Male">
&nbsp; &nbsp;<label>Male</label>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="radio" name="Gender" value="Female" >
&nbsp; &nbsp;<label>Female</label><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<button type="submit">Submit</button>
</form>
</body>
</html>