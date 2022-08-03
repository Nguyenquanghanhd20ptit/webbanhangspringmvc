<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<<div class="span9">
		<ul class="breadcrumb">
			<li><a href="/hanhIT">Trang Chủ</a> <span class="divider">/</span></li>
			<li><a href="/hanhIT/dangki">Đăng Kí</a> <span class="divider">/</span></li>
		</ul>
		<h3>Đăng Nhập Tài Khoản</h3>
		<hr class="soft" />
		<div class="well">
			<form class="form-horizontal" method="post" action="dangnhap" >
				<h3 style="text-align: center;"> ${tbao }</h3>
				<br />
				<h3 style="text-align: center; color:red;"> ${status }</h3>
				<br />
			     <div class="control-group">
					<label class="control-label">Tài Khoản <sup>*</sup></label>
					<div class="controls">
						<input type="text"  name="taikhoan" placeholder="Tài Khoản" >
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Mật Khẩu <sup>*</sup></label>
					<div class="controls">
						<input  type="password" name="password" placeholder="Password" >
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<input type="submit" name="submitAccount" value="Đăng Nhập"
							class="exclusive shopBtn"> <a href="#">Quên Mật Khẩu?</a>
					</div>
				</div>
			</form>
		</div>
</body>
</html>