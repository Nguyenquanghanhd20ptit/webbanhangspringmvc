<%@page import="laptrinh.modell.products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
	<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
	   <c:forEach items="${categories }" var="category">
		  <li><a href="<c:url value="/san_pham/${category.id }/1" />"> <span class="icon-circle-blank"></span>${category.ten }</a></li>
		</c:forEach>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Đã Mua  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="<c:url value="/assets/img/paypal.jpg"/>" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product/15" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img  src="<c:url value="/assets/img/nhan.jpg"/>" alt="bootstrap ecommerce templates">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product/15">VIEW</a> <span class="pull-right">$2500</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product/20" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="<c:url value="/assets/img/shopping-cart-template.PNG"/>" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product/20">VIEW</a> <span class="pull-right">$2000</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product/12" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="<c:url value="/assets/img/tui.jpg"/>" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product/12">VIEW</a> <span class="pull-right">$200</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	<div class="span9">
	<div class="well np">
		<div id="myCarousel" class="carousel slide homCar">
            <div class="carousel-inner">
              <c:forEach items="${slides }" var="slide">
			  <div class="item">
                <img style="width:100% ; max-height:327px;" src=${slide.img } alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                      <h4>${slide.caption }</h4>
                      <br/> <br/> <br/> <br/>
                      <h4><span>${slide.content }</span></h4>
                </div>
              </div>
              </c:forEach>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
          </div>
        </div>
<!--
New Products
-->
	<div class="well well-small">
	<h3>Sản Phẩm Mới </h3>
	<hr class="soften"/>
		<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
					<c:if test="${ newProducts.size() > 0 }">
						<div class="item active">
							<ul class="thumbnails">
							<c:forEach var="item" items="${ newProducts }" varStatus="loop">
								<li class="span3">
									<div class="thumbnail">
										<a class="zoomTool" href="product/${ item.id_product }"
											title="add to cart"><span class="icon-search"></span>
											QUICK VIEW</a> <a href="product/${ item.id_product }"><img
											src="<c:url value="/assets/img/${ item.img }"/>" alt="" style="height: 192px;"></a>
									</div>
								</li>
								<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1)  == newProducts.size() }">
										</ul>
									</div>
									<c:if test="${ (loop.index + 1) < newProducts.size() }">
										<div class="item">
											<ul class="thumbnails">
									</c:if>
								</c:if>
							</c:forEach>
					</c:if>
						
					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
	</div>
	<!--
	Featured Products
	-->
		<div class="well well-small">
		  <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span class="icon-plus"></span></a> Sản Phẩm Nổi Bật  </h3>
		  <hr class="soften"/>
		  <div class="row-fluid">
		  <c:if test="${ nbProducts.size() > 0 }">
					<ul class="thumbnails">
					
					<c:forEach var="item" items="${ nbProducts }" varStatus="loop">
					   <li class="span4">
						  <div class="thumbnail">
							<a class="zoomTool" href="product/${ item.id_product }"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="product/${ item.id_product }"><img
									src="<c:url value="/assets/img/${ item.img }"/>"
								    	alt="" style="height: 266px;"></a>
							<div class="caption">
							  <h5>${item.ten }</h5>
							  <h4>
								  <a class="defaultBtn" href="product/${ item.id_product }" title="Click to view"><span class="icon-zoom-in"></span></a>
								  <a class="shopBtn" href="<c:url value="/AddCart/${item.id_product }"/>" title="add to cart"><span class="icon-plus"></span></a>
								  <span class="pull-right"><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price }" />	 ₫</span>
							  </h4>
							</div>
						  </div>
						</li>
						
						<c:if test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == nbProducts.size() }">
							</ul>
							<c:if test="${ (loop.index + 1) < nbProducts.size() }">
								<ul class="thumbnails">
							</c:if>
						</c:if>
						
					</c:forEach>
					
				</c:if>
		
	</div>
	</div>
	
	<div class="well well-small">
	<a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
	Popular Products 
	</div>
	<hr>
	<div class="well well-small">
	<a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
	Best selling Products 
	</div>
	</div>
	</div>