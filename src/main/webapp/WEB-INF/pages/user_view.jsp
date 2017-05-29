<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/user-edit.css"%>
    </style>
</head>
<body>
<div class="user-edit-container">
    <div class="user-edit-form">
        <h3>Add new user</h3>
        <spring:form method="POST" modelAttribute="cuser" action="usr">
            <spring:input type="hidden" path="userId"/>
            <div class="form-group">
                <label>Username: </label>
                <spring:input cssClass="form-control" path="userLogin"/>
            </div>
            <div class="form-group">
                <label>Password: </label>
                <spring:input cssClass="form-control" path="userPassword"/>
            </div>
            <div class="form-group">
                <label>User type ID: </label>
                <spring:input cssClass="form-control" path="userTypeId"/>
            </div>
            <div class="submit">
                <spring:button>Edit</spring:button>
            </div>
        </spring:form>
    </div>
</div>
</body>
</html>
