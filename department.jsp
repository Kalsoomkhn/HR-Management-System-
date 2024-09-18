<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Entry</title>
</head>
<body>
<h1 style="text-align: center;">Department Selection</h1><br/><br/>
    <form action="depart" method="post">
        &nbsp; &nbsp;&nbsp; &nbsp;<label>Department ID:</label>
        <input type="text" name="departmentId" required><br><br>
        &nbsp; &nbsp;&nbsp; &nbsp;<label>Department Name:</label>
         <input type="text" name="departmentName" required><br><br>
        &nbsp; &nbsp;&nbsp; &nbsp;<button type="submit">Submit</button>
    </form>
</body>
</html>