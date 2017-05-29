<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 21.05.2017
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Stations popularity</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/ticketpop.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="ticket-info">
        <p><strong>Stations popularity from ${sdate} to ${fdate}</strong></p>
        <c:if test="${not empty lists}">
            <table border="0" class="table">
                <caption>Stations popularity</caption>
                <c:forEach items="${lists}" var="res">
                    <tr>
                        <td>${res}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
