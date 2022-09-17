<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="../common/title.jsp"></jsp:include>

<body>
	<jsp:include page="../common/admin-header.jsp"></jsp:include>
	<div class="container">
		<div class="d-flex flex-wrap justify-content-center">
			<div
				class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
				<span class="fs-4">Dish List</span>
			</div> <a href="<%=request.getContextPath()%>/dish/new"
				class="btn btn-success">Add Dish</a>
		</div>
		<hr>
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

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
