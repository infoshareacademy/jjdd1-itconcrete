<%--
  Created by IntelliJ IDEA.
  User: katarzynadobrowolska
  Date: 20.05.2017
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="bars/header.jsp" %>

<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">
        <div class="navbar-header navbar-right" style="padding-top: 15px;">
            <a  href= "/line_popularity" role="button" class="btn btn-info btn-xs">
                <span class="glyphicon glyphicon-stats" aria-hidden="true"></span>
                Line Popularity Report
            </a>
        </div>
        <div class="navbar-header navbar-right" style="padding-top: 15px; padding-right: 15px;">
            <a  href= "/stop_popularity" role="button" class="btn btn-info btn-xs">
                <span class="glyphicon glyphicon-stats" aria-hidden="true"></span>
                BusStop Popularity Report
            </a>
        </div>
    </div>
</nav>

<%--<%@include file="backfooter.jsp" %>--%>

</body>
</html>
