<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh Toán</title>
</head>
<body>
	<div class="span9">
		<ul class="breadcrumb">
			<li><a href="/hanhIT">Trang Chủ</a> <span class="divider">/</span></li>
			<li><a href="/hanhIT/dangnhap"> Đăng Nhập</a> <span
				class="divider">/</span></li>
		</ul>
		<h3>Thanh Toán Đơn Hàng</h3>
		<hr class="soft" />
		<div class="well">
			<form:form class="form-horizontal" action="checkout" method="post" modelAttribute="user">
			<h3 style="text-align: center;">${status}</h3>
				<div class="control-group">
					<label class="control-label" for="inputFname"> Họ Và Tên <sup>*</sup></label>
					<div class="controls">
						<form:input type="text" path="hoten" id="inputFname"
							placeholder="Họ Và Tên" />
						<p style="color: red;">
							<form:errors path="hoten"></form:errors>
						</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputEmail">Email <sup>*</sup></label>
					<div class="controls">
						<form:input type="text"  path="email" placeholder="Email" />
						<p style="color: red;">
							<form:errors path="email"></form:errors>
						</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputLname"> Liên Hệ <sup>*</sup>
					</label>
					<div class="controls">
						<form:input type="text" path="sdt" id="inputLname"
							placeholder="Số Điện Thoại" />
						<p style="color: red;">
							<form:errors path="sdt"></form:errors>
						</p>

					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputLname"> Địa Chỉ <sup>*</sup></label>
					<div class="controls">
						<form:input type="text" path="diachi" id="inputLname"
							placeholder="Địa Chỉ" />
						<p style="color: red;">
							<form:errors path="diachi"></form:errors>
						</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Ghi Chú <sup>*</sup></label>
					<div class="controls">
						<textarea name = "ghichu"></textarea>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="submit" name="submitAccount" value="Thanh Toán"
							class="shopBtn exclusive">
					</div>
				</div>
			</form:form>
		</div>
</body>
</body>
</html>