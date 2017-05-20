<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header" style="padding-top: 7px; padding-bottom: 15px">
                <h2><span class="label label-info">Smartconnect</span></h2>
            </div>

                <c:choose>
            <c:when test="${sessionData.logged}">
            <div class="navbar-header navbar-right" style="padding-top: 7px;">
            <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <img src="${sessionData.googleUser.picture}" style="height: 30px">
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><span style="padding-left: 15px; padding-right: 15px">You are logged as:</span></li>
                            <li><span style="padding-left: 15px; padding-right: 15px">${sessionData.googleUser.given_name} ${sessionData.googleUser.family_name}</span></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="http://localhost:8080/report">Report module</a></li>
                            <li><a href="http://localhost:8080/about">About</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="http://localhost:8080/google/logout">Log out</a></li>
                        </ul>
                    </li>
                    </c:when>
                    <c:otherwise>
                <div class="navbar-header navbar-right" style="padding-top: 20px">
                <a href="http://localhost:8080/login" class="btn btn-default btn-xs" role="button"
                           style="width: 60px; padding-top: 7px; padding-bottom: 7px;">Log in</a>
                    </c:otherwise>
                    </c:choose>
            </div>
            </div>
    </nav>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
