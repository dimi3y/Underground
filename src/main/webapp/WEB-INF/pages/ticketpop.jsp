<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ticket popularity</title>
</head>
<body>
    Tickets popularity from ${sdate} to ${fdate}
    <c:if test="${not empty lists}">
        <table border="1">
            <caption></caption>
            <%--tr>
                <th>TICKET_TYPE</th>
            </tr--%>
            <c:forEach items="${lists}" var="res">
                <tr><td>${res}</td></tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
