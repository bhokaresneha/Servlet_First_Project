<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 04/07/22
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi<%=request.getAttribute("user") %>, Login Successful.</h3>
<a href="Login.html">Login Page</a>
</body>
</html>
