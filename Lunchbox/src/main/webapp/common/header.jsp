<style>
.header {
	margin-bottom: 16px;
}
</style>

<header>
	<nav class="header navbar navbar-expand-md navbar-dark"
		style="background-color: DarkOrange">
		<div>
			<a href="<%=request.getContextPath()%>" class="navbar-brand">Lunchbox</a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>" class="nav-link">Dashboard</a></li>
		</ul>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/login"
				class="nav-link">Admin</a></li>
			<li><a href="<%=request.getContextPath()%>/logout"
				class="nav-link">History</a></li>
			<li><a href="<%=request.getContextPath()%>/logout"
				class="nav-link">Cart</a></li>
		</ul>
	</nav>
</header>