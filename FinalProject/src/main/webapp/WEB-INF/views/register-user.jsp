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
<title>SignUp!</title>
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
	<div class="row">
	<form:form modelAttribute="customer" action="${contextPath}/register" method="post" 
		class="form-horizontal">
		<div class="form-group">
			<label for="userName" class="col-sm-4 control-label">User
				Name: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="userName"
					path="userName" placeholder="User Name" required="required" pattern='[a-zA-Z0-9 ]{2,}' title="No special characters allowed. Atleast longer than 2 letters."/>
			</div>
		</div>
		<div class="form-group">
			<label for="userPassword" class="col-sm-4 control-label">Password:
			</label>
			<div class="col-sm-8">
				<form:input type="password" class="form-control" id="userPassword"
					path="userPassword" placeholder="Password" required="required" pattern='[a-zA-Z0-9 ]{2,}' title="No special characters allowed. Atleast longer than 2 letters." />
			</div>
		</div>
		<div class="form-group">
			<label for="emailid" class="col-sm-4 control-label">Email Id:
			</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="emailId"
					path="emailId" placeholder="emailId" required="required" pattern="^[^@]+@[^@]+\.[^@]+$" title="Please enter a valid email address."/>
			</div>
		</div>
		<div class="form-group">
			<label for="fName" class="col-sm-4 control-label">First Name:
			</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="fName" path="fName"
					placeholder="First Name" required="required" pattern='[a-zA-Z]{2,}'
									title="No special characters allowed. Atleast longer than 2 letters." />
			</div>
		</div>
		<div class="form-group">
			<label for="lName" class="col-sm-4 control-label">Last Name:
			</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="lName" path="lName"
					placeholder="Last Name" required="required" pattern='[a-zA-Z]{2,}'
									title="No special characters allowed. Atleast longer than 2 letters."  />
			</div>
		</div>
		<div class="form-group">
			<label for="address" class="col-sm-4 control-label">Address:
			</label>
			<div class="col-sm-8">
				<form:input type="textarea" class="form-control" id="address"
					path="address" placeholder="Address" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="phNumber" class="col-sm-4 control-label">Phone
				Number: </label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="phNumber"
					path="phNumber" placeholder="Phone Number" required="required" pattern="\b\d{3}[-.]?\d{3}[-.]?\d{4}\b" title="Please enter a valid phone number"/>
			</div>
		</div>
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" name="signup" class="btn btn-primary"
				value="Save My Information" />
		</div>
	</form:form>
	</div>
	</div>
</body>
</html>