<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Operator page</title>
    <style>
        <%@ include file="./styles/bootstrap.min.css"%>
        <%@ include file="./styles/operator.css"%>
    </style>
</head>
<body>
<div class="operator-container">

    <div class="header">
        <div class="title">
            <h1>Operator page</h1>
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

    <div class="operator-table-container">
        <table border="0" class="table operator-control-table">
            <caption></caption>
            <tr>
                <form method="get" action="tpop" class="">
                    <td>
                        <p><strong>Tickets popularity</strong></p>
                        <label>From: </label><input class="form-control" type="text" name="sdate"/>
                        <label>To: </label><input class="form-control" type="text" name="fdate"/>
                    </td>
                    <td class="calculate-td">
                        <button class="btn btn-secondary">Calculate</button>
                    </td>
                </form>
            </tr>
            <tr>
                <form method="get" action="spop">
                    <td>
                        <p><strong>Stations popularity</strong></p>
                        <label>From: </label><input class="form-control" type="text" name="sdate"/>
                        <label>To: </label><input class="form-control" type="text" name="fdate"/>
                    </td>
                    <td class="calculate-td">
                        <button class="btn btn-secondary">Calculate</button>
                    </td>
                </form>
            </tr>
            <tr>
                <form method="get" action="upop">
                    <td>
                        <p><strong>Stations load on</strong></p>
                        <input class="form-control" type="text" name="date"/></td>
                    <td class="calculate-td">
                        <button class="btn btn-secondary">Calculate</button>
                    </td>
                </form>
            </tr>
            <tr>
                <form method="get" action="tact">
                    <td>
                        <p><strong>Active tickets</strong></p>
                    </td>
                    <td class="calculate-td">
                        <button class="btn btn-secondary">Calculate</button>
                    </td>
                </form>
            </tr>
            <tr>
                <form method="get" action="tblk">
                    <td>
                        <p><strong>Ticket id to block</strong></p>
                        <input class="form-control" type="text" name="id"/>
                    </td>
                    <td class="calculate-td">
                        <button class="btn btn-secondary">Calculate</button>
                    </td>
                </form>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
