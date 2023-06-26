<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2023
  Time: 8:11 AM
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
    <script src="<c:url value='/js/admin.js'/>" ></script>

</head>
<body>
<br>

<ul class="nav navbar-nav side-bar">
    <li class="side-bar tmargin">
        <a href="/product/hien-thi"class="btn btn-primary" role="button">
            <span class="glyphicon glyphicon-folder-open" >&nbsp;</span>Quản lý Sản phẩm</a>
    </li>
    <br>

    <li class="side-bar main-menu">
        <a href="/hien-thi"class="btn btn-primary" role="button">
            <span class="glyphicon glyphicon-signal" class="btn btn-primary" role="button">&nbsp;</span>Quản lý Khách Hàng </a>
    </li>

</ul>
<br>
<div class="row">
    <div class="col-11">
        <p>
            <a href="/product/create" class="btn btn-primary" role="button">Add new product</a>
        </p>
    </div>
</div>




<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Tên</th>
        <th scope="col">soluongton</th>
        <th scope="col">gianhap</th>
        <th scope="col">giaban</th>
        <th scope="col">Anh</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="sp" >
        <tr>
            <td>${sp.idSP}</td>
            <td>${sp.ten}</td>
            <td>${sp.soluongton}</td>
            <td>${sp.gianhap}</td>
            <td>${sp.giaban}</td>
            <td><img src="/image/${sp.image}" width="100"height="100" /></td>


            <td>
                <a href="/product/detail/${sp.idSP}" class="btn btn-primary" role="button"
                   onclick="return confirm('Bạn có muốn xem chi tiết hay không')">Detail</a>

                <a href="/product/delete/${sp.idSP}" class="btn btn-danger " role="button"
                   onclick="return confirm('Bạn có muốn xóa hay không')">Delete</a>

                    <%--                <a href="/delete/${sp.id}" class="btn btn-danger " role="button"--%>
                    <%--                   onclick="return confirm('Bạn có muốn Xem hay không')">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination">--%>
<%--        <c:forEach begin="0" end="${ listProduct.totalPages -1}" varStatus="loop">--%>
<%--            <li class="page-item">--%>
<%--                <a class="page-link" href="/product/hien-thi?page=${loop.begin + loop.count - 1}">--%>
<%--                        ${loop.begin + loop.count }--%>
<%--                </a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
<%--</nav>--%>
<form>
    <div>
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${page.getNumber() + 1 > 1}">
                    <a class="page-link" href="?page=${page.getNumber()}&ten=${param.ten}">
                        Previous
                    </a>
                </c:if>
            </li>
            <li class="page-item"><a class="page-link"> ${page.getNumber() + 1}</a></li>
            <li class="page-item"><a class="page-link">/</a></li>
            <li class="page-item"><a class="page-link"> ${page.getTotalPages()}</a></li>
            <li class="page-item"><c:if test="${page.getNumber() + 1 lt page.getTotalPages()}">
                <a class="page-link" href="?page=${page.getNumber() + 2}&ten=${param.ten}">
                    Next
                </a>
            </c:if>
            </li>
        </ul>
    </div>
</form>
</body>
</html>
