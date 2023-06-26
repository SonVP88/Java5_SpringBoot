<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/13/2023
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul class="navbar-nav mr-auto">
    <li class="nav-item active">
        <a class="nav-link" href="#"><s:message code="label.home.home"/><span class="sr-only">(current)</span></a>
    </li>
<%--    <li class="nav-item">--%>
<%--        <a class="nav-link" href="#"><s:message code="label.home.product"/></a>--%>
<%--    </li>--%>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <s:message code="label.home.shop"/>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#"><s:message code="label.home.about"/></a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
    </li>
</ul>
</body>
</html>
