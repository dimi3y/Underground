<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 21.05.2017
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Underground load analisys</title>
</head>
<body>
    Underground load (time/passage) on ${date}
    <c:if test="${not empty lists}">
        <table border="0">
            <caption></caption>
            <c:forEach items="${lists}" var="res">
                <tr><td>${res}</td></tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
