<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Add User</h1>
    <form action="Insert" method="post" >
        <p> User_name: <input type="text" name="uname"></p>
        <p>UserSalary: <input type="text" name="Usersal"></p>
        <p>UserDesignation: <input type="text" name="des"></p>
        <input type="submit" value="AddUser">
    </form>
</body>
</html>