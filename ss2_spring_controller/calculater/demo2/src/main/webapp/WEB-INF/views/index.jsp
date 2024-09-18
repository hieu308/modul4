<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/18/2024
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
    <input type="number" name="a" >
    <input type="number" name="b">
    <button type="submit" name="operation" value="+">+</button>
    <button type="submit" name="operation" value="-">-</button>
    <button type="submit" name="operation" value="x">x</button>
    <button type="submit" name="operation" value="/">/</button>
</form>
<h1>Result :${result}</h1>
</body>
</html>
