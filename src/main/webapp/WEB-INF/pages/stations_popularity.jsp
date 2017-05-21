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
</head>
<body>
    Stations popularity from ${sdate} to ${fdate}
    <c:if test="${not empty lists}">
        <table border="1">
            <caption>Stations popularity</caption>
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
