<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="/public/images/logo-ico-small.svg" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Sign up</title>
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
				<br /> <img alt="banner" src="/public/images/login.svg"
					class="img-fluid">
			</div>
			<div class="col-6 p-5">
				<form:form action="/signup" method="post"
					modelAttribute="account">
					<div class="text-center mb-5">
						<img alt="logo" src="/public/images/logo-ico-small.svg">
					</div>
					<div>
						<label>Full name</label>
						<form:input path="fullname" class="form-control" />
						<form:errors path="fullname" cssClass="text-danger" />
					</div>
					<div>
						<label>Email</label>
						<form:input path="email" type="email" class="form-control" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
					<div>
						<label>User name</label>
						<form:input path="username" class="form-control" />
						<form:errors path="username" cssClass="text-danger" />
					</div>
					<div>
						<label>Password</label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
					<div class="mt-3">
						<a href="/login" class="text-decoration-none">
						Log in now</a>
					</div>
					<button class="btn btn-primary w-100 mt-3">Sign up</button>
				</form:form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>