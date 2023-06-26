<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/18/2023
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f3f3f3;
        }

        .login-form {
            margin-top: 100px;
            padding: 50px;
            background-color: #ffffff;
            box-shadow: 0px 0px 5px #cccccc;
            border-radius: 5px;
        }
    </style>
</head>
<body >
<%--<br>--%>
<%--<div class="error">${message}</div>--%>
<%--&lt;%&ndash;<form:form modelAttribute="user" action="${pageContext.request.contextPath}" method="POST">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label>Username</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form:input path="username"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form:errors path="username" class="error"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label>Password</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form:password path="password"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form:errors path="password" class="error"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="submit" value="Login">&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;</form:form>&ndash;%&gt;--%>
<%--<form:form modelAttribute="khachhang" action="${pageContext.request.contextPath}" method="POST">--%>
<%--    <!-- Email input -->--%>
<%--    <div class="form-outline mb-4">--%>
<%--        <label class="form-label" for="form2Example1">Name</label>--%>
<%--        <form:input path="tenkh" id="form2Example1" class="form-control" />--%>
<%--        <form:errors path="tenkh" class="error"/>--%>

<%--    </div>--%>

<%--    <!-- Password input -->--%>
<%--    <div class="form-outline mb-4">--%>
<%--        <label class="form-label" for="form2Example2">Password</label>--%>
<%--        <form:password path="matkhau" id="form2Example2" class="form-control" />--%>
<%--        <form:errors path="matkhau" class="error"/>--%>

<%--    </div>--%>
<%--    <!-- Submit button -->--%>
<%--    <button type="submit" class="btn btn-primary btn-block mb-4"value="Login">Login</button>--%>
<%--</form:form>--%>

<div class="container">
    <h2 align="center" class="form-signin-heading">LOGIN</h2>
    <div class="row justify-content-sm-center">
        <div class="col-md-6 col-sm-8">
            <form class="login-form" action="/login" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email :</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="userName">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password:</label>
                    <input type="password" class="form-control" id="inputPassword"
                           placeholder="Password" name="passWord">
                </div><br/>
                <span style="color: red">${checkLogin == 1?"Tai khoan hoac mat khau khong chinh xac!":""}</span><br/>
                <center>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <a href="/home" type="submit" class="btn btn-primary">CLose</a>
                    <a href="/sign-up-view" type="submit" class="btn btn-primary">Sign up</a>
                </center>

            </form>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
