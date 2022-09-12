<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<jsp:include page="../common/title.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="../common/empty-header.jsp"></jsp:include>
	<div class="container col-lg-4 col-sm-12">
		<h2>Login</h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<div class="form-outline mb-4">
				<input type="text" class="form-control" id="username"
					placeholder="User Name" name="username" required>
			</div>

			<div class="form-outline mb-4">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="password" required>
			</div>

			<button type="submit" class="btn btn-primary btn-block mb-4">Sign
				in</button>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>