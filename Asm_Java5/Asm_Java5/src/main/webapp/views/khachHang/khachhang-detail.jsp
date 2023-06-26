<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Thêm Khách hàng mới</h2>

<form:form action="/save" method="post" modelAttribute="khachhang">
    <table>
        <tr>
            <td><form:label path="ma">Mã:</form:label></td>
            <td><form:input path="ma"/></td>
        </tr>
        <tr>
            <td><form:label path="ten">Tên:</form:label></td>
            <td><form:input path="ten"/></td>
        </tr>
        <tr>
            <td><form:label path="ngaySinh">Ngày sinh:</form:label></td>
            <td><form:input path="ngaySinh"/></td>
        </tr>
        <tr>
            <td><form:label path="diaChi">Địa chỉ:</form:label></td>
            <td><form:input path="diaChi"/></td>
        </tr>
        <tr>
            <td><form:label path="sdt">Số điện thoại:</form:label></td>
            <td><form:input path="sdt"/></td>
        </tr>
        <tr>
            <td><form:label path="matkhau">Mật khẩu:</form:label></td>
            <td><form:input path="matkhau"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td><form:label path="quocgia">Quốc gia:</form:label></td>--%>
<%--            <td><form:input path="quocgia"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
