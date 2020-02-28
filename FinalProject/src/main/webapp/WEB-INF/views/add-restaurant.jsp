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
<title>New Restaurant</title>
</head>
<body>
<div class="alert alert-info" role="alert">
		<h4 class="text-center">
			<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
			Add Restaurant
		</h4>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form modelAttribute="restaurant" action="${contextPath}/addRestaurant" method="post" 
		class="form-horizontal">
		<div class="form-group">
	<label for="rName" class="col-sm-4 control-label">Restaurant Name: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="rName"
					path="rName" placeholder="Restaurant Name" required="required" />
			</div>
		</div>
		<div class="form-group">
	<label for="rAddress" class="col-sm-4 control-label">Address: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="rAddress"
					path="rAddress" placeholder="Restaurant Address" required="required" />
			</div>
		</div>
		<div class="form-group">
	<label for="rNumber" class="col-sm-4 control-label">Contact Number: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="rNumber"
					path="rNumber" placeholder="Restaurant Contact Info" required="required" />
			</div>
		</div>
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" name="addRestaurant" class="btn btn-primary"
				value="Add Restaurant" />
		</div>
		</form:form>
</body>
</html>