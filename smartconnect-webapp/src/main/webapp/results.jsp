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

<c:forEach items="${completeTransferResultList}" var="completeTransferResult" varStatus="i">

    <div class="container" style="width: 600px;">

        <div class="panel panel-default">

            <div class="panel-heading" align="center">
                <h4 class="panel-title">


                    <c:choose>
                        <c:when test="${completeTransferResult.getStartLocation().equals('Dom')}">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${completeTransferResult.getStartLocation()}<br/><br/>
                        </c:when>
                        <c:otherwise>
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${completeTransferResult.getStartLocation()}<br/><br/>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${completeTransferResult.getEndLocation().equals('Dom')}">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${completeTransferResult.getEndLocation()}
                        </c:when>
                        <c:otherwise>
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${completeTransferResult.getEndLocation()}
                        </c:otherwise>
                    </c:choose>
                </h4>
            </div>

            <table class="table table-hover">
                <tr align="center" style="background-color: #fefefe">
                    <td width="20%">
                        <span class="glyphicon glyphicon-random" aria-hidden="true"></span>
                    </td>
                    <td width="30%">
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                            ${completeTransferResult.getStartBusStop()}
                    </td>
                    <td width="30%">
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                            ${completeTransferResult.getEndBusStop()}
                    </td>
                </tr>

                <c:choose>
                    <c:when test="${completeDirectResultList.get(i.index).getDirectResultConnectionList().size() > 0}">
                        <c:forEach items="${completeDirectResultList.get(i.index).getDirectResultConnectionList()}"
                                   var="directResultConnection">
                            <tr>

                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${directResultConnection.getLineNumber()}</a>
                                </td>

                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${directResultConnection.getTravelStartTime()}</a></td>


                                <td align="center" valign="center">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${directResultConnection.getTravelEndTime()}</a></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>


                <c:choose>
                    <c:when test="${completeTransferResultList.get(i.index).getTransferResultConnectionList().size() > 0}">
                        <c:forEach items="${completeTransferResultList.get(i.index).getTransferResultConnectionList()}"
                                   var="transferResultConnection">

                            <tr align="center">
                                <td width="20%">
                                    <span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
                                    <br/>
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${transferResultConnection.getFirstLineNumber()}</a>
                                    <br/><br/>
                                    <span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
                                    <br/>
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${transferResultConnection.getSecondLineNumber()}</a>
                                </td>
                                <td width="30%">
                                        ${transferResultConnection.getStartBusStop()}
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getDepartureFirstLine()}</a>
                                    <br/><br/>
                                        ${transferResultConnection.getMidBusStop()}
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getDepartureSecondLine()}</a>
                                </td>
                                <td width="30%">
                                        ${transferResultConnection.getMidBusStop()}
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getArrivalFirstLine()}</a>
                                    <br/><br/>
                                        ${transferResultConnection.getEndBusStop()}
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getArrivalSecondLine()}</a>
                                </td>
                            </tr>


                        </c:forEach>
                    </c:when>
                </c:choose>


                        <c:choose>
                            <c:when test="${completeDirectResultList.get(i.index).getDirectResultConnectionList().size() == 0 && completeTransferResultList.get(i.index).getTransferResultConnectionList().size() == 0}">
                                <tr>
                                    <td colspan="3" align="center"><span style="color: #5bc0de;">Sorry, there is no connection for this event.</span>
                                    </td>
                                </tr>
                            </c:when>
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