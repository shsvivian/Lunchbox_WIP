<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<jsp:include page="../common/title.jsp"></jsp:include>

<body>
	<div class="container">
		<h1 class="mt-5">Error</h1>
		<p class="lead"><%=exception.getMessage()%></p>
		<p>
			<a href="/">Back to Dashboard
		</p>
	</div>
</body>
</html>