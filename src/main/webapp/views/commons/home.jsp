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
								class="fa-solid fa-cart-shopping fs-4 position-relative"> <c:if
										test="${ countCart >0}">
										<span
											class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
											style="font-size: 0.5em"> ${ countCart } <span
											class="visually-hidden">unread messages</span>
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
		<%-- Slider --%>
		<div class="row" style="margin-top: 120px">
			<div id="carouselExampleInterval" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="10000">
						<img src="./public/images/post-slide-1.png"
							class="d-block w-100 rounded" alt="sale" style="height: 550px">
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<img src="./public/images/post-slide-2.png"
							class="d-block w-100 rounded" alt="sale" style="height: 550px">
					</div>
					<div class="carousel-item">
						<img src="./public/images/post-slide-3.png"
							class="d-block w-100 rounded" alt="sale" style="height: 550px">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleInterval" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
		<%-- Service --%>
		<div class="container mt-5 border rounded">
			<div class="row">
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange" src="./public/images/exchange-svgrepo-com.svg"
						height="45" width="45">
					<div>Exchange</div>
				</div>
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange"
						src="./public/images/free-shipping-svgrepo-com.svg" height="45"
						width="45">
					<div>Free ship</div>
				</div>
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange"
						src="./public/images/award-quality-svgrepo-com.svg" height="45"
						width="45">
					<div>Quality</div>
				</div>
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange" src="./public/images/flash-svgrepo-com.svg"
						height="45" width="45">
					<div>Cheap</div>
				</div>
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange"
						src="./public/images/shipping-fast-solid-svgrepo-com.svg"
						height="45" width="45">
					<div>Fast shipping</div>
				</div>
				<div
					class="col-2 d-flex justify-content-center align-items-center p-3">
					<img alt="exchange"
						src="./public/images/operator-customer-service-svgrepo-com.svg"
						height="45" width="45">
					<div>CSKH</div>
				</div>
			</div>
		</div>
		<%-- Main --%>
		<div style="background-color: #f5f5f5">
			<div class="container-fluid">
				<div class="row mt-5 p-5 gx-5">
					<div class="col-3">
						<h3>Danh mục</h3>
						<div class="list-group">
							<c:forEach items="${ listCate }" var="cate">
								<button type="button"
									class="list-group-item list-group-item-action"
									aria-current="true">${ cate.name }</button>
							</c:forEach>
						</div>
					</div>
					<div class="col-9">
						<h3>Sản phẩm</h3>
						<div class="row row-cols-1 row-cols-md-4 g-4">
							<c:forEach items="${ data.content }" var="pro">
								<div class="col">
									<div class="card h-100">
										<img src="${ pro.image }" class="card-img-top"
											alt="${ pro.name }">
										<div class="card-body">
											<h5 class="card-title">
												<a class="text-decoration-none"
													href="/user/buy-product/${ pro.id }">${ pro.name }</a>
											</h5>
											<p class="card-text text-danger">${ pro.price }VND</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<%-- Pagination --%>
						<div class="row mt-5">
							<ul class="pagination justify-content-center">
								<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
									<li class="page-item mx-1"><a
										class="page-link ${ index==page?'bg-black text-white':'' }"
										href="/home?page=${ index }">${ index + 1 }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
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