<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header" style="padding-bottom: 10px;">
                <h2><span class="label label-info">Smartconnect</span></h2>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <img src="${sessionData.user.picture}" style="height: 20px">
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><span style="padding-left: 15px; padding-right: 15px">You are logged</span></li>
                        <li><span style="padding-left: 15px; padding-right: 15px"><strong>logged: </strong><${sessionData.user.email}/span></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="http://localhost:8080/signout">Log out</a></li>
                    </ul>
                </li>
            </ul>
            <%--<div align="right" style="padding-top: 15px; padding-right: 15px">--%>
            <%--<a href="/login" class="btn btn-default" role="button">User <c:if test="${empty oauth.email}">not</c:if>logged</a>--%>
            <%--</div>--%>
        </div>
    </nav>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
