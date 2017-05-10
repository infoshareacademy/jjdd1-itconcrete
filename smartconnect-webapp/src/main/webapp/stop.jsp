<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - BusStop Popularity Statistics</title>
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

<div class="chart" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%,-50%); width: 25%; height: 25%;">
    <canvas id="myChart2"></canvas>
</div>


<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">
        <div class="navbar-header">
            <nav aria-label="footer">
                <ul class="pager">
                <li class="previous"><a href="/smartconnect_form">
                    <span aria-hidden="true">&larr;  </span>Back to main page</a>
                </li>
                </ul>
                </nav>

        </div>
    </div>
</nav>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.js"></script>
<script src="../js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script>
    var ctx2 = document.getElementById("myChart2");
    var config = {
        type: 'polarArea',
        data: {
            labels: [<c:forEach items="${statistics}" var="statistic">
                "${statistic.busStopName}" ,
                </c:forEach>],
            datasets: [{
                label: '# of Votes',
                data: [<c:forEach items="${statistics}" var="statistic">
                    ${statistic.countedTimes} ,
                    </c:forEach>],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            title:{
                display: true,
                fontSize: 20,
                text: 'BusStops popularity chart'
//                position: 'top'
            }
//            legend: {
//                display: true,
//                position: 'right'
//            }
        }
    };
    var myChart2 = new Chart(ctx2, config);
</script>
</body>
</html>
