<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ticket information</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/ticketpop.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="ticket-info">

        <table border="0" class="table">
            <caption></caption>
            <tr>
                <th>TICKET_ID</th>
                <th>TICKET_TYPE</th>
                <th>PASSAGES_COUNT</th>
                <th>ACTIVATION_DATE</th>
            </tr>

            <tr>
                <td>${ticket.ticketId}</td>
                <td>${ticket.ticketTypeId}</td>
                <td>${ticket.passageCount}</td>
                <td>${ticket.activationDate}</td>
            </tr>
        </table>

        <table border="0" class="table">
            <caption>Passages</caption>
            <tr>
                <th>PASSAGE_ID</th>
                <th>STATION_ID</th>
                <th>TICKET_ID</th>
                <th>PASSAGE_DATE</th>
            </tr>
            <c:forEach items="${passages}" var="passage">
                <tr>
                    <td>${passage.passageId}</td>
                    <td>${passage.stationId}</td>
                    <td>${passage.ticketId}</td>
                    <td>${passage.passageDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
