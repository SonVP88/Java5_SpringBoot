<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/9/2023
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<div class="container-fluid">
    <div class="col-md-3">

        <div id="sidebar">
            <div class="container-fluid tmargin">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search..." />
                    <span class="input-group-btn">
              <button class="btn btn-default">
                <span class="glyphicon glyphicon-search"></span>
              </button>
            </span>
                </div>
            </div>
            <br/>
            <ul class="nav navbar-nav side-bar">
                <li class="side-bar tmargin">
                    <a href="/product/hien-thi">
                        <span class="glyphicon glyphicon-folder-open">&nbsp;</span>Quản lý Sản phẩm</a>
                </li>

                <li class="side-bar main-menu">
                    <a href="/hien-thi">
                        <span class="glyphicon glyphicon-signal">&nbsp;</span>Quản lý Khách Hàng </a>
                </li>

            </ul>
        </div>
    </div>

    <script src="<c:url value='/js/admin.js'/>" ></script>
