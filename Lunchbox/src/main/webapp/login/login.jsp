<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<jsp:include page="../common/title.jsp"></jsp:include>

<body>
	<jsp:include page="../common/empty-header.jsp"></jsp:include>
	<div class="d-flex align-items-center justify-content-center">
		<div class="container col-lg-4 col-sm-12">
			<h1 class="h3 mb-3 fw-normal">Lunchbox Admin Portal</h1>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<div class="form-outline mb-4">
					<input type="text" class="form-control" id="username"
						placeholder="User Name" name="username" required>
				</div>

				<div class="form-outline mb-4">
					<input type="password" class="form-control" id="password"
						placeholder="Password" name="password" required>
				</div>

				<button type="submit" class="btn btn-primary btn-block mb-4 w-100">Sign
					in</button>
			</form>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>