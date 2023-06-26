<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2023
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<br>
<div class="row">
    <div class="col-11">
        <p>
            <a href="/sign-up-view" class="btn btn-primary" role="button">Add new product</a>
        </p>
    </div>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên Khach Hàng</th>
        <th scope="col">NgaySinh</th>
        <th scope="col">DiaChi</th>
        <th scope="col">Sdt</th>
<%--        <th scope="col">ThanhPho</th>--%>
        <th scope="col">Email</th>
        <th scope="col">MatKhau</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang.content}" var="kh">
        <tr>
            <td>${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.sdt}</td>
            <td>${kh.email}</td>
<%--            <td>${kh.quocgia}</td>--%>
            <td>${kh.matkhau}</td>
            <td>
                <a href="/edit-khachhang/${kh.id}" class="btn btn-primary" role="button"
                   onclick="return confirm('Bạn có muốn xem chi tiết hay không')">Detail</a>

                <a href="/delete/${kh.id}" class="btn btn-danger " role="button"
                   onclick="return confirm('Bạn có muốn xóa hay không')">Delete</a>

                    <%--                <a href="/delete/${sp.id}" class="btn btn-danger " role="button"--%>
                    <%--                   onclick="return confirm('Bạn có muốn Xem hay không')">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${ listKhachHang.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/hien-thi?page=${loop.begin + loop.count - 1}">
                        ${loop.begin + loop.count }
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>
