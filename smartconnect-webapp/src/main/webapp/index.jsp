<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - Results</title>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header" style="padding-bottom: 10px;">
                <h2><span class="label label-info">Smartconnect</span></h2>
            </div>
        </div>
    </nav>
</div>

<div class="container" style="padding-top: 75px;"></div>

<c:forEach items="${resultForWebAppList}" var="journey">

    <div class="container" style="width: 500px;">

        <div class="panel panel-default">

            <div class="panel-heading" align="center">
                <h4 class="panel-title">


                    <c:choose>
                        <c:when test="${journey.getStartLocation().equals('Dom')}">

                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${journey.getStartLocation()}<br/><br/>
                        </c:when>
                        <c:otherwise>
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${journey.getStartLocation()}<br/><br/>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${journey.getEndLocation().equals('Dom')}">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${journey.getEndLocation()}
                        </c:when>
                        <c:otherwise>
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${journey.getEndLocation()}
                        </c:otherwise>
                    </c:choose>
                </h4>
            </div>

            <table class="table table-hover">
                <tr align="center">
                    <td width="20%">
                        <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                    </td>
                    <td width="30%">
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                            ${journey.getStartBusStop()}
                    </td>
                    <td width="30%">
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                            ${journey.getEndBusStop()}
                    </td>
                </tr>
                <c:choose>
                    <c:when test="${journey.getResultConnectionList().size() > 0}">
                        <c:forEach items="${journey.getResultConnectionList()}" var="resultConnection">
                            <tr>

                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">
                                            ${resultConnection.getLineNumber()}</a>
                                </td>

                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${resultConnection.getTravelStartTime()}</a></td>


                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${resultConnection.getTravelEndTime()}</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="3" align="center"><span style="color: #5bc0de;">Sorry, there is no direct connection for this event</span>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
    <br/>
</c:forEach>

<div class="container">
    <nav aria-label="footer">
        <ul class="pager">
            <li class="previous"><a href="/smartconnect_form"><span aria-hidden="true">&larr;  </span>Seek again</a>
            </li>
        </ul>
    </nav>
</div>

<br/><br><br/>

<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">
        <div class="navbar-header"></div>
    </div>
</nav>

</body>
</html>