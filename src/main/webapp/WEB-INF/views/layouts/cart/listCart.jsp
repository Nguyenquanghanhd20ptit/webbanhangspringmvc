<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
<title>Giỏ hàng</title>
</head>
<body>
<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ hàng</li>
    </ul>
	<div class="well well-small">
	  <c:if test="${not empty Cart }">
	    <h1>Giỏ hàng <small class="pull-right"> Có ${TotalQuantyCart } sản phẩm trong giỏ hàng </small></h1>
	  </c:if>
	   <c:if test="${ empty Cart }">
	    <h1>Giỏ hàng <small class="pull-right"> Có 0 sản phẩm trong giỏ hàng </small></h1>
	  </c:if>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Mô tả</th>
                  <th>Màu sắc</th>
                  <th>Giá bán</th>
                  <th>Số lượng </th>
                  <th>Chỉnh sửa </th>
                  <th>Xóa </th>
                  <th>Tổng tiền</th>
				</tr>
              </thead>
              <tbody>
              
				<c:forEach var="item" items="${ Cart }">
					<tr>
	                  <td><img width="100" src="<c:url value="/assets/img/${ item.value.product.img }"/>" alt=""></td>
	                  <td>${ item.value.product.title }</td>
	                  <td><span class="shopBtn" style="background-color: ${ item.value.product.name_color };"><span class="icon-ok"></span></span> </td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.product.price }"/> ₫</td>
	                  <form action="/hanhIT/EditCart/${ item.key }" method="post">
		                  <td>
							<input name="quantyProduct" type="number" min="1" max="1000" class="span1" style="max-width:34px" placeholder="1" id="quantyCart_${ item.key }" size="16" type="text" value="${ item.value.quanty }">
						  </td>
		                  <td>
		                  	<button  class="btn btn-mini btn-danger " type="submit">
		                  		<span class="icon-edit"></span>
		                  	</button>
		                  </td>
	                  </form>
	                  <td>
	                  	<a href="<c:url value="/DeleteCart/${ item.key }"/>" class="btn btn-mini btn-danger" type="button">
	                  		<span class="icon-remove"></span>
	                  	</a>
	                  </td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.totalPrice }"/> ₫</td>
	                </tr>
				</c:forEach>
                
				</tbody>
            </table><br/>
			
	<a href="/hanhIT/" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp tục mua sắm </a>
    <c:if test="${not empty Cart }">
       <a href="/hanhIT/checkout" class="shopBtn btn-large pull-right">Thanh toán <span class="icon-arrow-right"></span></a>
      </c:if>
</div>
</div>
</div>

</body>