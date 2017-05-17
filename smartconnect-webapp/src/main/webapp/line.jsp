<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - Line Popularity Statistics</title>
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

<div class="chart" style="position: fixed; top: 50%; left: 50%; transform: translate(-50%,-50%); width: 75%; height: 75%;">
    <canvas id="myChart1"></canvas>
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
    var ctx1 = document.getElementById("myChart1");
    var config = {
        type: 'bar',
        data: {
            labels: [<c:forEach items="${statistics}" var="statistic">
                ${statistic.lineNumber} ,
                </c:forEach>],
            datasets: [{
                label: '# of Votes',
                data: [<c:forEach items="${statistics}" var="statistic">
                    ${statistic.countedTimes} ,
                    </c:forEach>],
                backgroundColor:
                    'rgba(91, 192, 222, 0.5)',
                borderColor:
                    'rgba(91, 192, 222, 0.1)',

                borderWidth: 1
            }]
        },
        options: {
            title: {
                display: true,
                fontSize: 20,
                text: " Line popularity chart"
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
                        labelString: 'Line number',
                        fontSize: 15
                    }
                }]
            }
        }
    };
    var myChart1 = new Chart(ctx1, config);
</script>

</body>
</html>

