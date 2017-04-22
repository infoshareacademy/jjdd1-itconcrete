<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <title>SmartConnect</title>
    <meta charset="utf-8">
    <title>SmartConnect</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>SmartConnect</h1>
    <br/>
    <h3>Hello! Please enter some journey details</h3>
    <br/>

    <form name="askForm" method="post" action="/smartconnect_results">
        <div class="form-group">
            <label for="homeBusStop">Home bus:</label>
            <input type="text" class="form-control" id="homeBusStop" placeholder="Enter your home bus stop name">
        </div>
        <div class="form-group">
            <label for="timeOfLeavingHome">Time of leaving home:</label>
            <input type="time" class="form-control" id="timeOfLeavingHome" placeholder="Enter time of leaving home (Format HH:MM)">
        </div>
        <div class="form-group">
            <label for="timeOfArrivingingHome">Time of leaving home:</label>
            <input type="time" class="form-control" id="timeOfArrivingingHome"
                   placeholder="Enter time of arriving home (Format HH:MM)">
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
    </form>
</div>

</body>
</html>