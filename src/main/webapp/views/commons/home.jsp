<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./public/images/logo-ico-small.svg" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
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
					src="./public/images/logo-ico.svg" width="80" height="80">
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
								<li><a class="dropdown-item" href="./admin">Admin</a></li>
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
							<button type="button"
								class="list-group-item list-group-item-action active"
								aria-current="true">The current button</button>
							<button type="button"
								class="list-group-item list-group-item-action">A second
								item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A third
								button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A fourth
								button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
							<button type="button"
								class="list-group-item list-group-item-action">A
								disabled button item</button>
						</div>
					</div>
					<div class="col-9">
						<h3>Sản phẩm</h3>
						<div class="row row-cols-1 row-cols-md-4 g-4">
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a short card.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card h-100">
									<img
										src="https://giayxshop.vn/wp-content/uploads/2021/12/z3046271490155_1f3ecf7b2b959a31273e4856fcddcc7e-scaled.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Card title</h5>
										<p class="card-text">This is a longer card with supporting
											text below as a natural lead-in to additional content. This
											content is a little bit longer.</p>
									</div>
								</div>
							</div>
						</div>
						<%-- Pagination --%>
						<div class="row mt-3">
							<nav aria-label="..." class="d-flex justify-content-center">
								<ul class="pagination">
									<li class="page-item disabled"><span class="page-link">Previous</span>
									</li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item active" aria-current="page"><span
										class="page-link">2</span></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">Next</a>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%-- Footer --%>
		<div class="row mt-5 p-4" style="background-color: #0a3d62">
			<div class="col-4 text-center">
				<img alt="logo" src="./public/images/logo-ico-small.svg">
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
					<label for="exampleFormControlInput1" class="form-label" style="color: #dcdde1">Email
						address</label> <input type="email" class="form-control"
						id="exampleFormControlInput1" placeholder="name@example.com">
					<button type="button" class="btn btn-primary w-100 mt-2">Send</button>
				</form>
			</div>
			<hr>
			<p class="text-center text-white fw-bold">Made by trucnvph17923</p>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>