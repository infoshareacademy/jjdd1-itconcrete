<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - Welcome!</title>

    <style>
        #animation {
            width: 50px;
            height: 75px;
            background-image: url("img/1493607493_vehicles-12.png");
            background-repeat: no-repeat;
            position:relative;
            -webkit-animation: mymove 50s infinite;
            animation: mymove 50s infinite;
        }

        @-webkit-keyframes mymove {
            0%   {left: 10%;}
            100% {left: 90%;}
        }

        @keyframes mymove {
            0%   {left: 10%;}
            100% {left: 90%;}
        }
    </style>

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

<div class="container" style="width: 500px; padding-top: 75px" align="center">
    <h3>Hello! Please enter some journey details</h3>
</div>

<div id="animation"></div>

<div class="container" style="width: 450px;">
    <form name="askForm" method="post" action="/smartconnect_form" enctype="multipart/form-data">

        <div class="form-group ${hasError1}">
            <label class="control-label" for="maxAmountOfResults">Home bus stop</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></span>
                <input type="text" class="form-control" id="homeBusStop" name="homeBusStop"
                       placeholder="${homeBusStopError}Enter home bus stop name"
                       value="${homeBusStop}"
                       aria-describedby="inputGroupSuccess1Status">
            </div>
        </div>

        <div class="form-group ${hasError2}">
            <label class="control-label" for="timeOfLeavingHome">Time of arriving home</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                <input type="time" class="form-control" id="timeOfLeavingHome" name="timeOfLeavingHome"
                       placeholder="${timeOfLeavingError}Enter time of leaving home (HH:MM)"
                       value="${timeOfLeavingHome}"
                       aria-describedby="inputGroupSuccess1Status">
            </div>
        </div>

        <div class="form-group ${hasError3}">
            <label class="control-label" for="maxAmountOfResults">Time of arriving home</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
                <input type="time" class="form-control" id="timeOfArrivingHome" name="timeOfArrivingHome"
                       placeholder="${timeOfArrivingError}Enter time of arriving home (HH:MM)"
                       value="${timeOfArrivingHome}"
                       aria-describedby="inputGroupSuccess1Status">
            </div>
        </div>

        <div class="form-group ${hasError4}">
            <label class="control-label" for="maxAmountOfResults">Maximum amount of results</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-random" aria-hidden="true"></span></span>
                <input type="text" class="form-control" id="maxAmountOfResults" name="maxAmountOfResults"
                       placeholder="${maxResultsError}Enter maximum amount of results (1-10)"
                       value="${maxAmountOfResults}"
                       aria-describedby="inputGroupSuccess1Status">
            </div>
        </div>

        <div class="form-group ${hasError5}">
            <label class="control-label" for="calendarFile">Upload calendar file</label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
                <input type="file" class="form-control" id="calendarFile" name="calendarFile" value="${calendarFile}" aria-describedby="inputGroupSuccess1Status">
            </div>
            <p class="help-block ${hasError5}">${calendarFileError}</p>
        </div>

        <button type="submit" class="btn btn-info">Submit</button>
    </form>
</div>


<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">
        <div class="navbar-header navbar-right">
            <a  href= "/line_popularity" role="button" class="btn btn-primary btn-xs" >
                <span class="glyphicon glyphicon-stats" aria-hidden="true"></span>
                Line Popularity Report
            </a>
        </div>
    </div>
</nav>

</body>
</html>