<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 03.05.2016
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currency calculator</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" href="./css/signin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">


    <script src="./js/jquery-2.2.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
</head>

<body>
<div class="container">
    <form class="form-inline" method="POST">
        <div class="form-group">
            <label for="input">Отдаете:</label>
            <input type="number" step="any" class="form-control" id="input" name="input" value="${input}">
        </div>
        <select class="selectpicker" data-width="fit" name="inputCurrency">
            <option value="RUB" <c:if test="${inputCurrency=='RUB'}">selected="selected"</c:if> data-icon="fa-rub"></option>
            <option value="BTC" <c:if test="${inputCurrency=='BTC'}">selected="selected"</c:if> data-icon="fa-bitcoin"></option>
        </select>
        <div class="btn-group-vertical">
            <button type="submit" name="convertType" value="fromUsd" class="btn btn-info">
                <span class="btn-label"><i class="glyphicon glyphicon-chevron-left"></i></span>
            </button>
            <button type="submit" name="convertType" value="toUsd" class="btn btn-info">
                <span class="btn-label"><i class="glyphicon glyphicon-chevron-right"></i></span>
            </button>
        </div>
        <div class="form-group">
            <label for="output">Получаете:</label>
            <input type="number" step="any" class="form-control" id="output" name="output" value="${output}">
        </div>
        <i class="fa fa-dollar"></i>
    </form>
</div>

<script type="text/javascript">
    $('.selectpicker').selectpicker({
        iconBase: 'fa',
        tickIcon: 'fa-check'
    });
</script>

</body>
</html>