<style>
.header-nav {
	margin-bottom: 16px;
}
</style>

<header class="header-nav">
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: DarkOrange">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://getbootstrap.com/docs/5.2/assets/brand/bootstrap-logo.svg"
				alt="Logo" width="30" height="24"
				class="d-inline-block align-text-top"> Lunchbox
			</a>
			<button class="navbar-toggler p-0 border-0" type="button"
				id="navbarSideCollapse" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse offcanvas-collapse"
				id="navbarsExampleDefault">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#">Dashboard</a></li>
					<li class="nav-item"><a class="nav-link" href="#">History</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Cart</a></li>
				</ul>
				<div class="d-flex">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/login">Admin</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
</header>