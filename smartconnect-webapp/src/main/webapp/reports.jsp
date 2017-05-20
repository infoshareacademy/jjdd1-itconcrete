<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="google-signin-client_id"
          content="1092866121133-5hu5u791n1op9qanolt6nshutoibja0u.apps.googleusercontent.com">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - Reports</title>
</head>
<body>

<%@include file="bars/login_header.jsp" %>

<br/>
<div class="container" style="width: 500px; padding-top: 75px" align="center">
    <h2>Statistic Reports</h2>
</div>

<div align="center">

    <br/><br/><br/><br/>

    <a href="/line_popularity" role="button" class="btn btn-info btn-lg" style="width: 400px;">
        <%--<span class="glyphicon glyphicon-stats" aria-hidden="true"></span>&nbsp;--%>
        <h4>Line Popularity Report</h4></a>

    <br/><br/><br/><br/><br/><br/>

    <a href="/stop_popularity" role="button" class="btn btn-info btn-lg" style="width: 400px">
        <%--<span class="glyphicon glyphicon-stats" aria-hidden="true"></span>&nbsp;--%>
        <h4>Bus Stop Popularity Report</h4></a>

    <br/><br/><br/><br/><br/><br/>

    <a href="/another_report" role="button" class="btn btn-info btn-lg" style="width: 400px">
        <%--<span class="glyphicon glyphicon-stats" aria-hidden="true"></span>&nbsp;--%>
        <h4>Another Report ???</h4></a>


</div>


<%@include file="backfooter.jsp" %>

</body>
</html>
