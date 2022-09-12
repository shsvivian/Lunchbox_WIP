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
			<li><a href="<%=request.getContextPath()%>/dish" class="nav-link">Dish</a></li>
			<li><a href="<%=request.getContextPath()%>/dish" class="nav-link">Menu</a></li>
			<li><a href="<%=request.getContextPath()%>/dish" class="nav-link">Order</a></li>
		</ul>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath()%>/dashboard"
				class="nav-link">Logout</a></li>
		</ul>
	</nav>
</header>