<style>
.header {
	margin-bottom: 16px;
}
</style>

<header>
	<nav class="header navbar navbar-expand-md navbar-dark"
		style="background-color: DarkOrange">

		<div class="navbar-brand">LunchBox</div>


		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/login"
				class="nav-link">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/register"
				class="nav-link">Signup</a></li>
		</ul>
	</nav>
</header>