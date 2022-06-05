<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="/ASM_JAVA5/public/images/logo-ico-small.svg" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login</title>
</head>
<style>
//
Scrollbar CSS

html *::-webkit-scrollbar {
	border-radius: 0;
	width: 8px;
}

html *::-webkit-scrollbar {
	border-radius: 0;
	width: 8px;
}

html *::-webkit-scrollbar-thumb {
	background-color: rgba(0, 0, 0, .15);
}

html *::-webkit-scrollbar-thumb {
	background-color: rgba(0, 0, 0, .15);
}

html *::-webkit-scrollbar-track {
	border-radius: 0;
	background-color: rgba(0, 0, 0, 0);
}

html *::-webkit-scrollbar-track {
	border-radius: 0;
	background-color: rgba(0, 0, 0, 0);
}
</style>
<body>
	<div class="container">
		<div class="row" style="height: 100vh">
			<div class="col-6 p-5">
				<br /> <img alt="banner" src="/ASM_JAVA5/public/images/login.svg"
					class="img-fluid">
			</div>
			<div class="col-6 p-5">
				<form action="/ASM_JAVA5/login" method="post">
				<div class="text-center mb-5">
					<img alt="logo" src="/ASM_JAVA5/public/images/logo-ico-small.svg">
				</div>
				<h4>Login to continue</h4>
					<div>
						<label>Email</label> <input class="form-control" type="email"
							name="email" />
					</div>
					<div>
						<label>Password</label> 
						<input class="form-control" type="password" name="password" />
					</div>
					<button class="btn btn-primary w-100 mt-4">Login</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>