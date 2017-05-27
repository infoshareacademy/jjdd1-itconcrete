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
    <title>SmartConnect - Welcome!</title>
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>

<%@include file="bars/login_header.jsp" %>

<%--<c:choose>--%>
<%--<c:when test="${sessionData.logged}">--%>

<br/>
<div class="container" style="width: 500px; padding-top: 75px" align="center"><h3>Check your bus stop
    location</h3></div>
<br/>


<div class="container" style="width: 450px;">

    <%--<div class="form-group">--%>
    <%--<div class="input-group">--%>
    <%--<span class="input-group-addon"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span></span>--%>
    <%--<input type="text" class="form-control" id="busStop" name="busStop" placeholder="${busStopError}Enter bus stop name"--%>
    <%--value="${busStop}" aria-describedby="inputGroupSuccess1Status">--%>
    <%--<button type="submit" class="btn btn-info">Submit</button>--%>
    <%--</div>--%>
    <%--</div>--%>

    <form name="askForm" method="post" action="/map" enctype="multipart/form-data">
        <div class="input-group">
            <input type="text" class="form-control" id="busStop" name="busStop" placeholder="${busStopError}Enter bus stop name">
            <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
        </div>
    </form>

</div>

<div align="center">
    <div id="map"></div>
    <script>
        function initMap() {
            var uluru = {lat: -25.363, lng: 131.044};
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 4,
                center: uluru
            });
            var marker = new google.maps.Marker({
                position: uluru,
                map: map
            });
        }
    </script>
</div>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAbkEbhKKuC0cjdZd0tkz7-qaWxJAvjWZw&callback=initMap">
</script>

<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<%@include file="/login_body.jsp" %>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>

<%@include file="bars/empty_footer.jsp" %>

</body>
</html>