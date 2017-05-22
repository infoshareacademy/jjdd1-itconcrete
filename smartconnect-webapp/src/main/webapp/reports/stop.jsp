<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <title>SmartConnect - Bus Stop Popularity Statistics</title>
</head>
<body>

<%@include file="../bars/login_header.jsp" %>

<c:choose>
    <c:when test="${sessionData.logged}">

        <div class="chart"
             style="position: fixed; top: 50%; left: 50%; transform: translate(-50%,-50%); width: 75%; height: 75%;">
            <canvas id="myChart2"></canvas>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.js"></script>
        <script src="../js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
        <script>
            var ctx2 = document.getElementById("myChart2");
            var config = {
                type: 'bar',
                data: {
                    labels: [<c:forEach items="${statistics}" var="statistic">
                        "${statistic.busStopName}",
                        </c:forEach>],
                    datasets: [{
                        label: '# of Votes',
                        data: [<c:forEach items="${statistics}" var="statistic">
                            ${statistic.countedTimes},
                            </c:forEach>],
                        backgroundColor: 'rgba(91, 192, 222, 0.5)',
                        borderColor: 'rgba(91, 192, 222, 0.1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    title: {
                        display: true,
                        fontSize: 20,
                        text: 'Bus stops popularity chart'
//                position: 'top'
                    },
                    scales: {
                        yAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Occurences in search',
                                fontSize: 15
                            },
                            ticks: {
                                beginAtZero: true
                            }
                        }],
                        xAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Bus stop name',
                                fontSize: 15
                            }
                        }]
                    }
//            legend: {
//                display: true,
//                position: 'right'
//            }
                }
            };
            var myChart2 = new Chart(ctx2, config);
        </script>
    </c:when>
    <c:otherwise>
        <%@include file="/login_body.jsp" %>
    </c:otherwise>
</c:choose>

<%@include file="../bars/back_stats_footer.jsp" %>

</body>
</html>

