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
<title>Login!</title>
</head>
<body>
<div class="container">
	<div class="alert alert-info" role="alert">
		<h4 class="text-center">
			<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
			Food Order Application
		</h4>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form modelAttribute="user" action="${contextPath}/login"
		method="post" class="form-horizontal">
		<div class="form-group">
			<label for="userName" class="col-sm-4 control-label">User
				Name: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="userName"
					path="userName" placeholder="User Name" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="userPassword" class="col-sm-4 control-label">Password:
			</label>
			<div class="col-sm-8">
				<form:input type="password" class="form-control" id="userPassword"
					path="userPassword" placeholder="Password" required="required" />
			</div>
		</div>
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" name="login" class="btn btn-primary"
				value="Login" />
		</div>
	</form:form>
	</div>
</body>
</html>