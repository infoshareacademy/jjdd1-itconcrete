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
    <title>SmartConnect - Welcome!</title>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container" style="width: 600px; padding-top: 75px" align="center">

    <br/>
    <h2>Plan your everyday travels. Effective.</h2>
    <br/><br/>
    <img src="img/Zrzut%20ekranu%202017-05-17%20o%2021.06.31.png">
    <br/><br/><br/>
    <h3>Please log in to start</h3>
    <br/><br/>

    <a href="http://localhost:8080/google/login" class="btn btn-info btn-lg" role="button">LOG IN</a>

    <div class="g-signin2" data-onsuccess="onSignIn"></div>


    <%--<input type="submit" name="login" value="LOG IN" class="btn btn-info btn-lg" align="center">--%>
    <%--</form>--%>
    <h5>with Google</h5>

    <%--<script src="https://apis.google.com/js/platform.js" async defer></script>--%>

</div>

<%@include file="footer.jsp" %>

</body>
</html>