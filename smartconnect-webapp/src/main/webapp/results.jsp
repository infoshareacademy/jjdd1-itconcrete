<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/results.css" rel="stylesheet">
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

    <div class="container" style="width: 500px;">

        <div class="panel panel-default">

            <div class="panel-heading" align="center">
                <h4 class="panel-title">

                    <c:choose>
                        <c:when test="${completeTransferResult.getStartLocation().equals('Dom')}">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${completeTransferResult.getStartLocation()}
                            &nbsp;&nbsp;&nbsp;
                            <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                            &nbsp;&nbsp;&nbsp;
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                            ${completeTransferResult.getEndLocation()}
                        </c:when>
                        <c:otherwise>
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${completeTransferResult.getStartLocation()}
                            &nbsp;&nbsp;&nbsp;
                            <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                            &nbsp;&nbsp;&nbsp;
                            <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                            ${completeTransferResult.getEndLocation()}
                        </c:otherwise>
                    </c:choose>

                </h4>
            </div>

            <table class="table table-hover">
                <c:choose>
                    <c:when test="${completeDirectResultList.get(i.index).getDirectResultConnectionList().size() > 0}">
                        <c:forEach items="${completeDirectResultList.get(i.index).getDirectResultConnectionList()}"
                                   var="directResultConnection">
                            <tr>
                                <td width="60%" style="vertical-align: middle">
                                        ${completeTransferResult.getStartBusStop()}
                                    <br/><br/>
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${directResultConnection.getLineNumber()}</a>
                                    <br/><br/>
                                        ${completeTransferResult.getEndBusStop()}
                                </td>
                                <td width="40%" style="vertical-align: middle">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${directResultConnection.getTravelStartTime()}</a>
                                    <br/>
                                        <%--<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>--%>
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${directResultConnection.getTravelEndTime()}</a>
                                    <br/>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>


                <c:choose>
                    <c:when test="${completeTransferResultList.get(i.index).getTransferResultConnectionList().size() > 0}">
                        <c:forEach items="${completeTransferResultList.get(i.index).getTransferResultConnectionList()}"
                                   var="transferResultConnection">

                            <tr>
                                <td style="vertical-align: middle">${transferResultConnection.getStartBusStop()}
                                    <br/><br/>
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${transferResultConnection.getFirstLineNumber()}</a>
                                    <br/><br/>
                                        ${transferResultConnection.getMidBusStop()}
                                    <br/><br/>
                                    <a href="#" class="btn btn-default disabled btn-info" role="button"
                                       style="width: 50px;">${transferResultConnection.getSecondLineNumber()}</a>
                                    <br/><br/>
                                        ${transferResultConnection.getEndBusStop()}

                                </td>
                                <td style="vertical-align: middle">
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getDepartureFirstLine()}</a>
                                    <br/>
                                        <%--<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>--%>
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getArrivalFirstLine()}</a>
                                    <br/><br/><br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getDepartureSecondLine()}</a>
                                    <br/>
                                        <%--<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>--%>
                                    <br/>
                                    <a href="#" class="btn btn-default disabled" role="button"
                                       style="width: 80px;">${transferResultConnection.getArrivalSecondLine()}</a>
                                    <br/>
                                </td>
                            </tr>

                        </c:forEach>
                    </c:when>
                </c:choose>


                <c:choose>
                    <c:when test="${completeDirectResultList.get(i.index).getDirectResultConnectionList().size() == 0 && completeTransferResultList.get(i.index).getTransferResultConnectionList().size() == 0}">
                        <tr>
                            <td colspan="2" align="center"><span style="color: #5bc0de;">Sorry, there is no connection for this event</span>
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