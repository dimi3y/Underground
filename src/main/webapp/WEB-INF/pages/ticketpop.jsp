<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ticket popularity</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/ticketpop.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="ticket-info">
        <p><strong>Tickets popularity from ${sdate} to ${fdate}</strong></p>
        <c:if test="${not empty lists}">
            <table border="0" class="table">
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
