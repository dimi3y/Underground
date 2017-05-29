<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/login.css"%>
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-form">
            <div class="login-message">
            ${message}
            </div>
            <spring:form cssClass="" method="POST" modelAttribute="user" action="main">
                <spring:input cssClass="form-control" path="userLogin"/>
                <spring:input cssClass="form-control" path="userPassword"/>
                <spring:button cssClass="btn btn-secondary" >Login</spring:button><br/>
            </spring:form>
        </div>
    </div>
</body>
</html>
