<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Active tickets</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/ticketpop.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="ticket-info">
        <p><strong>Active tickets</strong></p>
        <table border="0" class="table">
            <tr>
                <th>TICKET_ID</th>
                <th>TICKET_TYPE</th>
                <th>PASSAGES_COUNT</th>
                <th>ACTIVATION_DATE</th>
            </tr>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.ticketId}</td>
                    <td>${ticket.ticketTypeId}</td>
                    <td>${ticket.passageCount}</td>
                    <td>${ticket.activationDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
