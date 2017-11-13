<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 03.05.2016
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currency calculator</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/signin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">


    <script src="./js/jquery-2.2.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
</head>

<body>
<div class="container">
    <form class="form-inline">
        <div class="form-group">
            <label for="input">Отдаете:</label>
            <input type="number" class="form-control" id="input">
        </div>
        <select class="selectpicker" data-width="fit">
            <option data-icon="fa-rub"></option>
            <option data-icon="fa-bitcoin"></option>
        </select>
        <button type="submit" name="period" value="day" class="btn btn-labeled btn-info">
            <span class="btn-label"><i class="glyphicon glyphicon-refresh"></i></span>
        </button>
        <div class="form-group">
            <label for="output">Получаете:</label>
            <input type="number" class="form-control" id="output">
        </div>
        <i class="fa fa-dollar"></i>
    </form>
</div>

<script type="text/javascript">
    $('.alert-success').fadeTo(1500, 500).slideUp(500, function () {
        $(".alert-success").slideUp(500);
    });

    $('.selectpicker').selectpicker({
        iconBase: 'fa',
        tickIcon: 'fa-check'
    });
</script>

</body>
</html>