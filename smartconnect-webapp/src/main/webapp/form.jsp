<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>SmartConnect - Welcome!</title>
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

<div class="container" style="width: 500px; padding-top: 75px;" align="center">
    <h3>Hello! Please enter some journey details</h3>
</div>

<br/>

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

</body>
</html>