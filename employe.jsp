<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.List" %>
  <%@ page import="first.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees Entry</title>
</head>
<body> 
<h1 style="text-align: center;">New Employee Entry</h1><br/><br/>
<form action="employe" method="post">
&nbsp; &nbsp;&nbsp; &nbsp;<label>Employee ID</label>&nbsp; &nbsp;
&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<input type="text" name="ID" ><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Employee Name</label>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="username" required><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Password</label>&nbsp; &nbsp;
&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input type="password" name="password" required><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Department Name:</label>
    <select name="did">
      <%
        List<String> departmentNames = DatabaseConnection.getDepartmentNames();
      int  count=1;
        for (String departmentName : departmentNames) {
      %>
        <option value="<%= count %>"><%= departmentName %></option>
      <% count++;} %>
    </select><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<label>Select Gender</label><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="radio" name="Gender" value="Male">
&nbsp; &nbsp;<label>Male</label>
&nbsp; &nbsp;&nbsp; &nbsp;<input type="radio" name="Gender" value="Female" >
&nbsp; &nbsp;<label>Female</label><br/><br/>
&nbsp; &nbsp;&nbsp; &nbsp;<button type="submit">Submit</button>
</form>
</body>
</html>