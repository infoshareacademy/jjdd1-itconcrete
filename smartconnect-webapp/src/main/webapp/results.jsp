<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/results.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <title>SmartConnect - Results</title>
</head>
<body>

<%@include file="bars/login_header.jsp" %>

<c:choose>
    <c:when test="${sessionData.logged}">
        <div class="container" style="width: 500px; padding-top: 75px" align="center">
            <h3>Results</h3>
        </div>

        <div class="container" style="padding-top: 30px;"></div>

        <c:forEach items="${completeTransferResultList}" var="completeTransferResult" varStatus="i">

            <div class="container" style="width: 650px;">

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
                                </c:when>
                                <c:otherwise>
                                    <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                                    ${completeTransferResult.getStartLocation()}
                                    &nbsp;&nbsp;&nbsp;
                                    <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                                    &nbsp;&nbsp;&nbsp;
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
                        <c:choose>
                            <c:when test="${completeDirectResultList.get(i.index).getDirectResultConnectionList().size() > 0}">
                                <c:forEach
                                        items="${completeDirectResultList.get(i.index).getDirectResultConnectionList()}"
                                        var="directResultConnection">
                                    <tr>
                                        <td width="70%"
                                            style="vertical-align: middle; text-align: left; padding-left: 30px;">
                                            <br/>
                                            <a href="#" class="btn btn-default disabled btn-info" role="button"
                                               style="width: 50px;">${directResultConnection.getLineNumber()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${completeTransferResult.getStartBusStop()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${completeTransferResult.getEndBusStop()}</a>
                                            <br/>
                                        </td>
                                        <td width="30%" style="vertical-align: middle">
                                            <br/>
                                            <a href="#" class="btn btn-default disabled" role="button"
                                               style="width: 80px;">${directResultConnection.getTravelStartTime()}</a>
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
                                <c:forEach
                                        items="${completeTransferResultList.get(i.index).getTransferResultConnectionList()}"
                                        var="transferResultConnection">

                                    <tr>
                                        <td width="70%"
                                            style="vertical-align: middle; text-align: left; padding-left: 30px;">
                                            <br/>
                                            <a href="#" class="btn btn-default disabled btn-info" role="button"
                                               style="width: 50px;">${transferResultConnection.getFirstLineNumber()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${transferResultConnection.getStartBusStop()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${transferResultConnection.getMidBusStop()}</a>
                                            <br/><br/>
                                            <a href="#" class="btn btn-default disabled btn-info" role="button"
                                               style="width: 50px;">${transferResultConnection.getSecondLineNumber()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${transferResultConnection.getMidBusStop()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button">
                                                    ${transferResultConnection.getEndBusStop()}</a>
                                            <br/>

                                        </td>
                                        <td width="30%" style="vertical-align: middle">
                                            <br/>
                                            <a href="#" class="btn btn-default disabled" role="button"
                                               style="width: 80px;">${transferResultConnection.getDepartureFirstLine()}</a>
                                            <a href="#" class="btn btn-default disabled" role="button"
                                               style="width: 80px;">${transferResultConnection.getArrivalFirstLine()}</a>
                                            <br/><br/>
                                            <a href="#" class="btn btn-default disabled" role="button"
                                               style="width: 80px;">${transferResultConnection.getDepartureSecondLine()}</a>
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

        <div style="padding-top: 100px;"></div>
    </c:when>
    <c:otherwise>
        <%@include file="/login_body.jsp" %>
    </c:otherwise>
</c:choose>

<%@include file="bars/back_main_footer.jsp" %>

</body>
</html>