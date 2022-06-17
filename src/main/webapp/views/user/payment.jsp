<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<title>Shoes shop</title>
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
	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg row shadow-sm fixed-top px-3"
			style="background-color: #0a3d62">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img alt="logo"
					src="/public/images/logo-ico.svg" width="80" height="80">
				</a>
				<button class="navbar-toggler " type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fa-solid fa-bars fs-2"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="/home">Home</a></li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Sale
								off</a></li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Contact
								us</a></li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Feedbacks</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white" href="#">History</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-white" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Category</a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="d-flex px-4">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link text-white"
							id="dropAccount" role="button" data-bs-toggle="dropdown"
							aria-expanded="false" href="#"> <i
								class="fa-solid fa-user fs-4"></i>
						</a>
							<ul class="dropdown-menu" aria-labelledby="dropAccount"
								style="top: auto; left: auto;">
								<sec:authorize access="!isAuthenticated()">
								 <li><a class="dropdown-item" href="/login">Login</a></li>
								</sec:authorize>
								<sec:authorize access="isAuthenticated()">
								  <li><a class="dropdown-item" href="/logout">Logout</a></li>
								</sec:authorize>
								<sec:authorize access="hasAuthority('1') and isAuthenticated()">
								<li><a class="dropdown-item" href="/admin">Manage Users</a></li>
								</sec:authorize>
							</ul></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="#"> <i
								class="fa-solid fa-magnifying-glass fs-4"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="/user/carts"> <i
								class="fa-solid fa-cart-shopping fs-4 position-relative"> 
								<c:if test="${ countCart >0}">								
								<span
									class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger" style="font-size: 0.5em">
										${ countCart } <span class="visually-hidden">unread messages</span>
								</span>
								</c:if>
							</i>
						</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="#"> <i
								class="fa-solid fa-wallet fs-4"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="#"> <i
								class="fa-solid fa-globe fs-4"></i>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<%-- Main --%>
		<div class="row bg-light p-3" style="margin-top: 130px">
			<h4>Thanh toán đơn hàng</h4>
		</div>
		<div class="container">
			<div class="row bg-light mt-3 p-5">
				<div class="col-6">
				<form:form action="/user/payment-verify" method="post" modelAttribute="payment">
					<h5>Địa chỉ nhận hàng</h5>
					<form:input path="shippingAddress" class="form-control" />
					<form:errors path="shippingAddress" cssClass="text-danger" />
					
					<button class="btn btn-danger w-100 mt-5">Xác nhận thanh toán</button>
				</form:form> 
				</div>
				<div class="col-4 offset-2">
					<img alt="payment" src="/public/images/undraw_shopping_app_flsj.svg" width="100%" height="auto">
				</div>
			</div>
		</div>
		<%-- Footer --%>
		<div class="row mt-5 p-4" style="background-color: #0a3d62">
			<div class="col-4 text-center">
				<img alt="logo" src="/public/images/logo-ico-small.svg">
				<p style="color: #dcdde1">FPT Polytechnic Shopping</p>
			</div>
			<div class="col-4">
				<p class="text-white fw-bold">INFORMATION</p>
				<p style="color: #dcdde1">About Us</p>
				<p style="color: #dcdde1">Delivery Information</p>
				<p style="color: #dcdde1">Privacy Policy</p>
				<p style="color: #dcdde1">Terms and Conditions</p>
				<p style="color: #dcdde1">Returns</p>
				<p style="color: #dcdde1">Gift Certificates</p>
			</div>
			<div class="col-4">
				<p class="text-white fw-bold">CONTACT US</p>
				<form action="">
					<label for="exampleFormControlInput1" class="form-label"
						style="color: #dcdde1">Email address</label> <input type="email"
						class="form-control" id="exampleFormControlInput1"
						placeholder="name@example.com">
					<button type="button" class="btn btn-primary w-100 mt-2">Send</button>
				</form>
			</div>
			<hr>
			<p class="text-center text-white fw-bold">Made by trucnvph17923</p>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>