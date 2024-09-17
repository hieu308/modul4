<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/17/2024
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Từ điển Anh-việt</h1>
<form action="translate" method="post">
    <p>Nhập tù cần tra</p>
    <input type="text" name="text">
    <button type="submit"> Dịch</button>
</form>
<p1>Kết quả: ${result}</p1>
</body>
</html>
