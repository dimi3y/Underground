<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin page</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/admin.css"%>
    </style>
</head>
<body>
<div class="admin-container">
    <div class="header">
        <div class="title">
            <h1>All users</h1>
        </div>
        <div class="user">
            <form method="get" action="/">
                <div>
                    <span>${message}</span>
                    <button class="btn btn-secondary">Logout</button>
                </div>
            </form>
        </div>
    </div>

    <div class="controls">
        <div class="search">
            <form method="POST" action="main" class="form-inline">
                <div class="form-group">
                    <input id="username" class="form-control" placeholder="Username" type="text" name="login"/>
                </div>
                <button class="btn btn-secondary">Search</button>
            </form>
        </div>

        <div class="add">
            <a href="usrview?edit_id=0" class="btn btn-primary">Add</a>
        </div>
    </div>
    <table border="0" class="table">
        <caption></caption>
        <tr>
            <th>USER_ID</th>
            <th>USER_LOGIN</th>
            <th>USER_PASSWORD</th>
            <th>USER_TYPE</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="cuser">
            <%--form action="usr" method="PUT"></form--%>
            <tr>
                <td>${cuser.userId}</td>
                <td>${cuser.userLogin}</td>
                <td>${cuser.userPassword}</td>
                <td>${types[cuser.userTypeId-1].userTypeName}</td>
                <td><a href="usrview?edit_id=${cuser.userId}">Edit</a></td>
                <td><a href="usr?delete_id=${cuser.userId}">Delete</a></td>
                    <%--td><spring:form action="usr" method="GET">
                        <input type='hidden' name='delete_id' value=${user.userId}/>
                        <button>Delete</button>
                    </spring:form>
                </td--%>
            </tr>
            <%--a href="add?edit=${user.userId}">Edit</a> | <a href="delete?userId=${user.id}">Delete</a--%>
        </c:forEach>
    </table>

</div>
</body>
</html>
