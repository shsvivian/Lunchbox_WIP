<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<jsp:include page="../common/title.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="../common/admin-header.jsp"></jsp:include>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Dish List</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Dish</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Description</th>
						<th>Picture</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dish" items="${dishList}">

						<tr>
							<td><c:out value="${dish.name}" /></td>
							<td><c:out value="${dish.price}" /></td>
							<td><c:out value="${dish.description}" /></td>
							<td><c:out value="${dish.picture}" /></td>

							<td><a href="edit?dishId=<c:out value='${dish.dishId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?dishId=<c:out value='${dish.dishId}' />">Delete</a></td>

							<!--  <td><button (click)="updateDish(dish.dishId)" class="btn btn-success">Update</button>
          							<button (click)="deleteDish(dish.dishId)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
