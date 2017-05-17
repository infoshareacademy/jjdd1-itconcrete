<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/animation.css" rel="stylesheet">
    <title>SmartConnect - Welcome!</title>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header" style="padding-bottom: 10px;">
                <h2><span class="label label-info">Smartconnect</span></h2>
            </div>

            <div align="right" style="padding-top: 7px; padding-right: 15px">
                    <button type="button" class="btn btn-default navbar-btn">User <c:if test="${empty oauth.email}"> not </c:if>logged</button>
            </div>
        </div>
    </nav>
</div>


<div class="container" style="width: 600px; padding-top: 75px" align="center">

    <br/>
    <h2>Plan your everyday travels. Effective.</h2>
    <br/><br/>
    <img src="img/Zrzut%20ekranu%202017-05-17%20o%2021.06.31.png">
    <br/><br/><br/>
    <h3>Please log in to start</h3>
    <br/><br/>

    <form method="post" action="login">
        <input name="login" type="hidden" value="1">
        <input type="submit" value="LOG IN" class="btn btn-info btn-lg" align="center">
    </form>
    <h5>with Google</h5>

</div>

<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">
        <div class="navbar-header">
            <nav aria-label="footer"></nav>
        </div>
    </div>
</nav>

</body>
</html>