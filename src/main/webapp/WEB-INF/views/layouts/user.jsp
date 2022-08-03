<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
      <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
   <link href="<c:url value='/assets/css/bootstrap.css' />" rel="stylesheet"/></link>
    <!-- Customize styles -->
    <link href="<c:url value='/assets/style.css' />" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="<c:url value='/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet">
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="<c:url value='/assets/ico/favicon.ico'/> ">
  </head>
<body>
   <tiles:insertAttribute name="header" />
   <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer"/>
    
    
    <!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src="<c:url value="/assets/img/maestro.png"/>" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/img/mc.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/img/pp.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/img/visa.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/img/disc.png"/>" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    
     <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value='/assets/js/jquery.js' />" ></script>
	   <script src="<c:url value='/assets/js/bootstrap.min.js' />" ></script>
	   <script src="<c:url value='/assets/js/jquery.easing-1.3.min.js' />" ></script>
       <script src="<c:url value='/assets/js/jquery.scrollTo-1.4.3.1-min.js' />" ></script>
       <script src="<c:url value='/assets/js/shop.js' />" ></script>
       
  </body>
</html>