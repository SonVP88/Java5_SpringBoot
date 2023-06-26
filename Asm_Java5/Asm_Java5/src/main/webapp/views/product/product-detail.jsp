<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2023
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container">
<br>
<section>

    <form:form action="/product/save" method="post" modelAttribute="product" enctype="multipart/form-data">
            <form:hidden path="idSP"/>
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">Name:</label>
            <form:input path="ten" id="form2Example1" class="form-control"/>

        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">SLT:</label>
            <form:input path="soluongton" id="form2Example1" class="form-control"/>

        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">GIANHAP:</label>
            <form:input path="gianhap" id="form2Example1" class="form-control"/>

        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">GIABAN:</label>
            <form:input path="giaban" id="form2Example1" class="form-control"/>

        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">MOTA:</label>
            <form:input path="mota" id="form2Example1" class="form-control"/>

        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">ANH:</label>
                <%--            <form:input path="anh" id="form2Example1" class="form-control"/>--%>
            <form:input type="file"  class="form-control-file" id="photo" path="image"/>

        </div>
        <br>
        <div class="form-group">
            <img src="${pageContext.request.contextPath}${imagePath}"  style="max-width: 300px; max-height: 300px;"/>
        </div>
        <br>

        <p>
            <button type="submit" class="btn btn-success">Update
            </button>
        </p>
    </form:form>
</section>
</body>
</html>
