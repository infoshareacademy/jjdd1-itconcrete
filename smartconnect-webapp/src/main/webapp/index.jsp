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

<div class="container" style="width: 70%;">


    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                    <span class="label label-success">smartconnect</span>
            </div>
        </div>
    </nav>

    <br/><br/><br/>

    <div class="progress">
        <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar"
             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
            <span class="sr-only">40% Complete (success)</span>
        </div>
    </div>

    <c:forEach items="${resultForWebAppList}" var="journey">
        <table class="table">

            <tr class="info">
                <td colspan="2">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getStartLocation()} &nbsp; &rarr; &nbsp;
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getEndLocation()}

                </td>
            </tr>
            <tr class="info">
                <td colspan="2">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getStartBusStop()} &nbsp; &rarr; &nbsp;
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        ${journey.getEndBusStop()}
                </td>
            </tr>

            <br/>

            <c:choose>
                <c:when test="${journey.getResultConnectionList().size() > 0}">
                    <c:forEach items="${journey.getResultConnectionList()}" var="resultConnection">
                        <tr>
                            <td align="center" width="20px"><b>${resultConnection.getLineNumber()}</b></td>
                            <td>
                                start journey at <b>${resultConnection.getTravelStartTime()}</b>,
                                you will reach your destination at <b>${resultConnection.getTravelEndTime()}</b>
                                    ${util.waiting()}
                            </td>
                        </tr>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>
                            <span style="color: #337ab7;">Sorry, there is no direct connection for this event</span>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </c:forEach>

    <nav aria-label="footer">
        <ul class="pager">
            <li class="previous"><a href="/smartconnect_form"><span aria-hidden="true">&larr;  </span>Seek again</a></li>
        </ul>
    </nav>

    <br/>

</div>
<br/>
</body>
</html>