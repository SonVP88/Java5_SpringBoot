<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2023
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.invalidate();    // hủy phiên đăng nhập hiện tại
    response.sendRedirect(request.getContextPath());  // chuyển hướng về trang chủ
%>
</body>
</html>
