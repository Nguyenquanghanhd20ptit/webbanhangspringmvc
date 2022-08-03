<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="span9">
		<ul class="breadcrumb">
			<li><a href="/hanhIT">Trang Chủ</a> <span class="divider">/</span></li>
		    <li><a href="/hanhIT/dangnhap"> Đăng Nhập</a> <span class="divider">/</span></li>
		</ul>
		<h3>Đăng Kí Tài Khoản</h3>
		<hr class="soft" />
		<div class="well">
			<form:form class="form-horizontal" modelAttribute="user"
				method="post" action="dangki" acceptCharset="utf-8">
				<h3 style="text-align: center;">${status}</h3>
				<br />
				<br />
			     <div class="control-group">
					<label class="control-label">Tài Khoản <sup>*</sup></label>
					<div class="controls">
						<form:input type="text"  path="taikhoan" placeholder="Tài Khoản" />
						<p style="color: red;">
							<form:errors path="taikhoan"></form:errors>
						</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Password <sup>*</sup></label>
					<div class="controls">
						<form:input  type="password" path="password" placeholder="Password" />
						<p style="color: red;">
							<form:errors path="password"></form:errors>
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
					<label class="control-label" for="inputFname"> Họ Và Tên <sup>*</sup></label>
					<div class="controls">
						<form:input type="text"   path="hoten" id="inputFname"
							placeholder="Họ Và Tên" />
						<p style="color: red;">
							<form:errors path="hoten"></form:errors>
						</p>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputLname">Tuổi <sup>*</sup></label>
					<div class="controls">
						<form:input type="number" path="tuoi" id="inputLname" min="1"
							max="125" placeholder="Tuổi" />
						<p style="color: red;">
							<form:errors path="tuoi"></form:errors>
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
					<label class="control-label" for="inputLname"> Số Điện
						Thoại <sup>*</sup>
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
					<div class="controls">
						<input type="submit" name="submitAccount" value="Đăng Kí"
							class="exclusive shopBtn">
					</div>
				</div>
			</form:form>
		</div>
</body>
</html>