<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2024
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Settings</h1>
    <form:form method="post" action="settingEmail" modelAttribute="setting" class="row g-3">
        <div class="col-md-6">
            <label for="language" class="form-label">Language</label>
            <form:select id="language" path="language" class="form-select">
                <form:option value="English" />
                <form:option value="Vietnamese" />
                <form:option value="Japanese" />
                <form:option value="Chinese" />
            </form:select>
        </div>
        <div class="col-md-6">
            <label for="page_size" class="form-label">Page Size</label>
            <form:select id="page_size" path="page_size" class="form-select">
                <form:option value="5" label="5"/>
                <form:option value="10" label="10"/>
                <form:option value="15" label="15"/>
                <form:option value="25" label="25"/>
                <form:option value="50" label="50"/>
                <form:option value="100" label="100"/>
            </form:select>
        </div>
        <div class="col-12">
            <label for="signature" class="form-label">Signature</label>
            <form:textarea id="signature" path="signature" class="form-control"></form:textarea>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/" class="btn btn-secondary">Cancel</a>
        </div>
    </form:form>
</div>
</body>
</html>
