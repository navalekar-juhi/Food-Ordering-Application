<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add Items</title>
</head>
<body>
	<div class="alert alert-info" role="alert">
		<h4 class="text-center">
			<span class="glyphicon glyphicon-time" aria-hidden="true"></span> Add
			Item
		</h4>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form modelAttribute="item"
		action="${contextPath}/additem" method="post"
		class="form-horizontal">
		<div class="form-group">
			<label for="itemName" class="col-sm-4 control-label">Item
				Name: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="itemName" path="itemName"
					placeholder="Item Name" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="itemPrice" class="col-sm-4 control-label">Item price:
			</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="itemPrice"
					path="itemPrice" placeholder="Item Price"
					required="required"  />
			</div>
		</div>
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" name="addItem" class="btn btn-primary"
				value="Add Item" />
		</div>
	</form:form>
</body>
</html>