<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/17/2024
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" METHOD="post">
    <input type="number" name="usd" > USD
    <button type="submit"> convert</button>
    <h2>${result} VND</h2>

</form>
</body>
</html>
