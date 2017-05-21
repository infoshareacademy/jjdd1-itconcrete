<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="google-signin-client_id" content="1092866121133-5hu5u791n1op9qanolt6nshutoibja0u.apps.googleusercontent.com">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/animation.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <title>SmartConnect - Log in</title>
</head>
<body>

<%@include file="bars/login_header.jsp" %>

<div class="container" style="width: 600px; padding-top: 75px" align="center">

    <br/>
    <h2>Plan your everyday travels. Effective.</h2>
    <br/><br/>
    <img src="img/temp_logo.png" height="220px">
    <br/><br/><br/>
    <h3>Please log in to start</h3>
    <br/><br/>

    <a href="http://localhost:8080/google/login" class="btn btn-info btn-lg" role="button">LOG IN</a>

    <%--<div class="g-signin2" data-onsuccess="onSignIn"></div>--%>

    <h5>with Google</h5>

    <%--<script src="https://apis.google.com/js/platform.js" async defer></script>--%>

</div>

<%@include file="bars/empty_footer.jsp" %>

</body>
</html>