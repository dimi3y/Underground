<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 23.05.2017
  Time: 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <form method="get" action="/">
        <p>${message}<button>Logout</button></p>
    </form>
    <a href="usrview?edit_id=${user.userId}">Edit</a>
    <form method="get" action="upsg">
        Information about ticket with id <input type="text" name="id"/><br/>
        <button>Find</button>
    </form>

</body>
</html>
