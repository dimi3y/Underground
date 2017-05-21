<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Active tickets</title>
</head>
<body>
    <table border="1">
        <caption>Active tickets table</caption>
        <tr>
            <th>TICKET_ID</th>
            <th>TICKET_TYPE</th>
            <th>PASSAGES_COUNT</th>
            <th>ACTIVATION_DATE</th>
        </tr>
        <c:forEach items="${tickets}" var="ticket">
            <tr><td>${ticket.ticketId}</td><td>${ticket.ticketType}</td><td>${ticket.passageCount}</td><td>${ticket.activationDate}</td></tr>
        </c:forEach>
    </table>
</body>
</html>
