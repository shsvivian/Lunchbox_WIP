<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="../common/title.jsp"></jsp:include>

<body>
	<jsp:include page="../common/admin-header.jsp"></jsp:include>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${dish != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${dish == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${dish != null}">
            			Edit Dish
            		</c:if>
						<c:if test="${dish == null}">
            			Add New Dish
            		</c:if>
					</h2>
				</caption>

				<c:if test="${dish != null}">
					<input type="hidden" name="dishId"
						value="<c:out value='${dish.dishId}' />" />
				</c:if>

				<fieldset class="mb-3">
					<label>Name</label> <input type="text"
						value="<c:out value='${dish.name}' />" class="form-control"
						name="name" required="required" />
				</fieldset>

				<fieldset class="mb-3">
					<label>Price</label> <input type="number" step=".01"
						value="<c:out value='${dish.price}' />" class="form-control"
						name="price" required="required">
				</fieldset>

				<fieldset class="mb-3">
					<label>Description</label>
					<textarea class="form-control" name="description" rows="3"><c:out
							value='${dish.description}' /></textarea>
				</fieldset>

				<fieldset class="mb-3">
					<label>Picture</label> <input type="text"
						value="<c:out value='${dish.picture}' />" class="form-control"
						name="picture" required="required">
				</fieldset>

				<div class="mb-3 d-grid d-md-flex justify-content-md-end">
					<a href="list" class="btn btn-secondary me-md-2">Back</a>
					<button type="submit" class="btn btn-success">Save</button>
				</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
