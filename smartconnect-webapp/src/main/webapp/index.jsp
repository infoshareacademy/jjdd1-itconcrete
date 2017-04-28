<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>SmartConnect</title>
</head>
<body>


<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <h3><span class="label label-info">Smartconnect</span></h3>
            </div>
        </div>
    </nav>
</div>

<br/><br/>

<div class="container" style="width: 40%;">
    <c:forEach items="${resultForWebAppList}" var="journey">
        <table class="table" align="center">

            <tr class="info" align="center">
                <td colspan="3">
                    <b>${journey.getStartLocation()}</b>&nbsp; &rarr; &nbsp;<b>${journey.getEndLocation()}</b>
                </td>
            </tr>
            <tr align="center">
                <td width="30%">
                    <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                </td>
                <td width="35%">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getStartBusStop()}
                </td>
                <td width="35%">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getEndBusStop()}
                </td>
            </tr>
            <br/>

            <c:choose>
                <c:when test="${journey.getResultConnectionList().size() > 0}">
                    <c:forEach items="${journey.getResultConnectionList()}" var="resultConnection">
                        <tr align="center">
                            <td align="center"><b>${resultConnection.getLineNumber()}</b></td>
                            <td>
                                ${resultConnection.getTravelStartTime()}
                            </td>

                            <td>
                                ${resultConnection.getTravelEndTime()}
                            </td>
                        </tr>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="3">
                            <span style="color: #337ab7;">Sorry, there is no direct connection for this event</span>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </c:forEach>
</div>

<div class="container">
<nav aria-label="footer">
    <ul class="pager">
        <li class="previous"><a href="/smartconnect_form"><span aria-hidden="true">&larr;  </span>Seek again</a></li>
    </ul>
</nav>
</div>

</body>
</html>