<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="/ASM_JAVA5/public/images/logo-ico.svg" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Account</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-2 p-4 shadow"
				style="background-color: #0a3d62; height: 100vh">
				<div class="d-flex justify-content-center">
					<a class="navbar-brand" href="#"> <img alt="logo"
						src="/ASM_JAVA5/public/images/logo-ico.svg" width="100"
						height="100">
					</a>
				</div>
				<hr>
				<div class="list-group">
					<p class="text-secondary fw-bold">Components</p>
					<a href="#" class="list-group-item list-group-item-action border-0"
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-gauge-high fs-6 px-1"></i></span> Dash board
					</a> <a href="./admin/accounts"
						class="list-group-item list-group-item-action border-0"
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-user fs-6 px-1"></i></span> Accounts
					</a> <a href="#"
						class="list-group-item list-group-item-action border-0 "
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-cart-shopping fs-6 px-1"></i></span> Products
					</a> <a href="#"
						class="list-group-item list-group-item-action border-0  "
						style="background-color: #0a3d62; color: #dcdde1"> <span>
							<i class="fa-solid fa-money-check-dollar fs-6 px-1"></i>
					</span> Payments
					</a> <a href="#"
						class="list-group-item list-group-item-action border-0  "
						style="background-color: #0a3d62; color: #dcdde1"> <span>
							<i class="fa-solid fa-arrow-down-9-1 fs-6 px-1"></i>
					</span> Sale off
					</a> <a href="#"
						class="list-group-item list-group-item-action border-0  "
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-truck-fast fs-6 px-1"></i></span> Orders
					</a>
					<p class="text-secondary fw-bold">Extras</p>
					<a href="#"
						class="list-group-item list-group-item-action border-0 "
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-message fs-6 px-1"></i></span> Feedbacks
					</a> <a href="#"
						class="list-group-item list-group-item-action border-0 "
						style="background-color: #0a3d62; color: #dcdde1"> <span><i
							class="fa-solid fa-gear fs-6 px-1"></i></span> Settings
					</a>
				</div>
			</div>
			<div class="col-10 px-0">
				<nav class="navbar navbar-expand-lg shadow-sm"
					style="background-color: #ffffff">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">Navbar w/ text</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarText"
							aria-controls="navbarText" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarText">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="#">Home</a></li>
								<li class="nav-item"><a class="nav-link" href="#">Features</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
								</li>
							</ul>
							<span class="navbar-text"> Navbar text with an inline
								element </span>
						</div>
					</div>
				</nav>
				<div class="bg-light p-3">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Admin</a></li>
							<li class="breadcrumb-item active" aria-current="page">Accounts</li>
						</ol>
					</nav>
				</div>
				<div class="px-4 p-3">
					<div class="row">
						<div class="col-3">
							<button class="btn btn-info text-white" data-bs-toggle="modal"
								data-bs-target="#modalAdd">Add new</button>
							<!-- Modal add -->
							<div class="modal fade" id="modalAdd" data-bs-backdrop="static"
								data-bs-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">Add a
												new account</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<form:form action="/ASM_JAVA5/admin/accounts/store"
												method="post" modelAttribute="account">
												<div>
													<label>Full name</label>
													<form:input path="fullname" class="form-control" />
												</div>
												<div>
													<label>Email</label>
													<form:input path="email" type="email" class="form-control" />
												</div>
												<div>
													<label>User name</label>
													<form:input path="username" class="form-control" />
												</div>
												<div>
													<label>Password</label>
													<form:password path="password" class="form-control" />
												</div>
												<div>
													<label>Photo</label>
													<form:input path="avatar" class="form-control" />
												</div>
												<div>
													<label>Admin</label>
													<form:select path="admin" class="form-select">
														<form:option value="0">Member</form:option>
														<form:option value="1">Admin</form:option>
													</form:select>
												</div>
												<button class="btn btn-primary w-100 mt-3" id="liveToastBtn">Add</button>
												<div class="position-fixed top-0 end-0 p-5"
													style="z-index: 11">
													<div style="background-color: #2ecc71" id="liveToast"
														class="toast align-items-center text-white border-0"
														role="alert" aria-live="assertive" aria-atomic="true">
														<div class="d-flex">
															<div class="toast-body">Successful !</div>
															<button type="button"
																class="btn-close btn-close-white me-2 m-auto"
																data-bs-dismiss="toast" aria-label="Close"></button>
														</div>
													</div>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-3 offset-6">
							<h1>Excel</h1>
						</div>

						<table class="table table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Full name</th>
									<th>User name</th>
									<th>Email</th>
									<th>Photo</th>
									<th>Activated</th>
									<th>Role</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ data.content }" var="acc">
									<tr>
										<td>${ acc.id }</td>
										<td>${ acc.fullname }</td>
										<td>${ acc.username }</td>
										<td>${ acc.email }</td>
										<td><img src="${ acc.avatar }" /></td>
										<td>${ acc.actived == 0 ? "In-Active" : "Active" }</td>
										<td>${ acc.admin == 1 ? "Admin" : "Member" }</td>
										<td class="text-center">
											<button class="btn btn-primary">
												<i class="fa-solid fa-pen-to-square"></i>
											</button>
										</td>
										<td class="text-center">
											<button class="btn btn-danger" data-bs-toggle="modal"
												data-bs-target="#modalDelte_${acc.id }">
												<i class="fa-solid fa-trash-can"></i>
											</button> <!-- Modal delete -->
											<div class="modal fade" id="modalDelte_${acc.id}"
												data-bs-backdrop="static" data-bs-keyboard="false"
												tabindex="-1" aria-labelledby="staticBackdropLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header bg-danger">
															<h5 class="modal-title text-white"
																id="staticBackdropLabel">Delete a new account !</h5>
															<button type="button" class="btn" data-bs-dismiss="modal"
																aria-label="Close">
																<i class="fa-solid fa-xmark fs-5 text-white"></i>
															</button>
														</div>
														<div class="modal-body" style="background-color: #fff2df">
															<p>Warming : You are trying a account. This account
																will be permanently deleted !</p>
															<a role="button"
																href="/ASM_JAVA5/admin/accounts/delete/${ acc.id }"
																class="btn btn-danger w-100 "> Delete </a>
														</div>
													</div>
												</div>
											</div>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>



						<div class="row">
							<ul class="pagination justify-content-center">
								<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
									<li class="page-item mx-1"><a
										class="page-link ${ index==page?'bg-black text-white':'' }"
										href="/ASM_JAVA5/admin/accounts/index?page=${ index }">${ index + 1 }</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var option = {
			animation : true,
			delay : 5000
		}
		document.getElementById("liveToastBtn").onclick = function() {
			var myAlert = document.getElementById("liveToast");
			var bsAlert = new bootstrap.Toast(myAlert, option);
			bsAlert.show();
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>