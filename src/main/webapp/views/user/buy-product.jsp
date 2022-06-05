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
<title>${ product.name }</title>
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
					src="/ASM_JAVA5/public/images/logo-ico.svg" width="80" height="80">
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
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Features</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Features</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Features</a>
						</li>
						<li class="nav-item"><a class="nav-link text-white" href="#">Pricing</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-white" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Dropdown
								link </a>
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
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><a class="dropdown-item" href="/ASM_JAVA5/admin">Admin</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="#"> <i
								class="fa-solid fa-magnifying-glass fs-4"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							aria-current="page" href="#"> <i
								class="fa-solid fa-cart-shopping fs-4"></i>
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
		<div class="bg-light p-3" style="margin-top: 120px">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb mb-0">
					<li class="breadcrumb-item"><a href="/ASM_JAVA5/">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">${ product.name }</li>
				</ol>
			</nav>
		</div>
		<%-- Main --%>
		<div class="container">
			<div class="row gy-1 p-5">
				<div class="col-6 p-2">
					<img alt="${ product.name }" src="${ product.image }" class="w-100">
				</div>
				<div class="col-6 px-5">
					<h1>${ product.name }</h1>
					<h4 class="text-danger fw-bold">${ product.price }
						<span>VND</span>
					</h4>
					<p class="mt-4">${ product.descriptions }</p>
					<h5>
						Loại sản phẩm : <span class="text-secondary">${ product.categories.name }</span>
					</h5>
					<h5>
						Trạng thái : <span class="text-secondary">${ product.available=='1'?'Còn hàng':'Hết hàng' }</span>
					</h5>
					<h5>Số lượng :</h5>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#">
								<i class="fa-solid fa-minus"></i>
							</a></li>
							<li class="page-item"> <p class="page-link text-black">10</p> </li>
							<li class="page-item"><a class="page-link" href="">
								<i class="fa-solid fa-plus"></i>
							</a></li>
						</ul>
					</nav>
					<button class="btn btn-info w-100 text-white">
						<i class="fa-solid fa-cart-shopping"></i> <span>ADD TO CART</span>
					</button>
				</div>
			</div>
		</div>
		<%-- Footer --%>
		<div class="row mt-5 p-4" style="background-color: #0a3d62">
			<div class="col-4 text-center">
				<img alt="logo" src="/ASM_JAVA5/public/images/logo-ico-small.svg">
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