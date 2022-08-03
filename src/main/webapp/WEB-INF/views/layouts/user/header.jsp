<%@page import="org.hibernate.dialect.function.VarArgsSQLFunction"%>
<%@page import="laptrinh.modell.menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a>
					<a href="#"><span class="icon-facebook"></span></a>
					<a href="#"><span class="icon-youtube"></span></a>
					<a href="#"><span class="icon-tumblr"></span></a>
				</div>
				<a class="active" href="/hanhIT"> <span class="icon-home"></span> Home</a> 
				<c:if test="${empty loginInfor }">
				<a href="/hanhIT/dangnhap"><span class="icon-user"></span> Đăng Nhập</a>  
				</c:if>
				<c:if test="${not empty loginInfor }">
				<a href="/hanhIT/dangnhap"><span class="icon-user"></span> ${loginInfor.hoten }</a>
				  <a href="/hanhIT/dangxuat"><span class="icon-edit"></span> Đăng Xuất </a> 
				</c:if>
				<a href="/hanhIT/dangki"><span class="icon-edit"></span> Đăng Kí </a> 
				<a href="contact.html"><span class="icon-envelope"></span> Thông Báo</a>
				
				<c:if test="${ not empty Cart }">
					<a href="/hanhIT/listCart"><span class="icon-shopping-cart"></span>${TotalQuantyCart } - Sản Phẩm  
					 <span class="badge badge-warning"> <fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart }" />₫ </span></a>
				 </c:if>
				 	<c:if test="${  empty Cart }">
			     <a href="/hanhIT/listCart"><span class="icon-shopping-cart"></span> 0 - Sản Phẩm  
					 <span class="badge badge-warning"> <fmt:formatNumber type="number" groupingUsed="true" value="0" />₫ </span></a>
				 </c:if>
				 
				
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
	<img src="<c:url value="/assets/img/logo-bootstrap-shoping-cart.png" />" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	<div class="offerNoteWrapper">
	<h1 class="dotmark">
	<i class="icon-cut"></i>
	Shoppe
	</h1>
	</div>
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Hỗ Trợ (24/7) :  0383870219 </strong><br><br></p>
	<span class="btn btn-mini">
	    ${TotalQuantyCart } 
     <span class="icon-shopping-cart"></span></span>
	<span class="btn btn-warning btn-mini">$</span>
	<span class="btn btn-mini">&pound;</span>
	<span class="btn btn-mini">&euro;</span>
	</div>
</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
					<c:forEach var="item" items="${ menus }" varStatus="index">
						<c:if test="${ item.id == sessionMenu }">
							<li class="active">
						</c:if>
						<c:if test="${ item.id != sessionMenu }">
							<li class="">
						</c:if>
						<a href="/hanhIT/${item.url }">${ item.ten } </a></li>
					</c:forEach>
					
				</ul>
			<form action="#" class="navbar-search pull-left">
			  <input type="text" placeholder="Search" class="search-query span2">
			</form>
			<ul class="nav pull-right">
			<li class="dropdown">
			  <c:if test="${empty loginInfor }"><a data-toggle="dropdown" class="dropdown-toggle" href="#">
			  <span class="icon-lock"></span> Đăng Nhập <b class="caret"></b></a>
			   </c:if>
			    <c:if test="${ not empty loginInfor }"><a data-toggle="dropdown" class="dropdown-toggle" href="#">
			  <span ></span> ${loginInfor.hoten }<b class="caret"></b></a>
			   </c:if>
				<div class="dropdown-menu">
				<form action="/hanhIT/login" method="post" class="form-horizontal loginFrm">
				  <div class="control-group">
				  <h3 style="text-align: center; color:red;"> ${tbao }</h3>
				    <%session.setAttribute("tbao", null); %>
					<input type="text" name="taikhoan" class="span2" id="inputEmail" placeholder="Tài Khoản">
				  </div>
				  <div class="control-group">
					<input type="password" name="password" class="span2" id="inputPassword" placeholder="Mật Khẩu">
				  </div>
				  <div class="control-group">
					<label class="checkbox">
					<input type="checkbox"> Remember me
					</label>
					<button type="submit" class="shopBtn btn-block">Đăng Nhập</button>
				  </div>
				</form>
				</div>
			</li>
			</ul>
		  </div>
		</div>
	  </div>
	</div>