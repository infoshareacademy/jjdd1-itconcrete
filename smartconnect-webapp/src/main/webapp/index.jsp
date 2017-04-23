<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <title>SmartConnect</title>
    <meta charset="utf-8">
    <title>SmartConnect</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>SmartConnect</h1>
    <br/>
    <h3>Results</h3>
    <br/>
    <c:forEach items="${resultForWebAppList}" var="journey">
        <table class="table">

            <tr class="info">
                <td colspan="2">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                    <b> From '${journey.getStartLocation()}' to '${journey.getEndLocation()}'
                        start journey at bus stop '${journey.getStartBusStop()}'
                        and get to '${journey.getEndBusStop()} with following lines:</b>
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
                            </td>
                        </tr>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>
                            Sorry, there is no direct connection for this event
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </c:forEach>

    <br/>
    <h4><a href="/smartconnect_form">Seek again!</a></h4>
    <br/>

</div>
<br/>
</body>
</html>