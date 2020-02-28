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
<title>View Restaurants</title>
</head>
<body>
<div class="container">
<div class="alert alert-info" role="alert">
		<h4 class="text-center">
			<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
			View Restaurant
		</h4>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form modelAttribute="restaurant" action="${contextPath}/viewItems" method="get" 
		class="form-horizontal">	
		<table border="1" cellpadding="5" cellspacing="5">
		<tr>	
			<td><b>Restaurant Id</b></td>
			<td><b>Restaurant Name</b></td>
			<td><b>Restaurant Address</b></td>
			<td><b>Restaurant Number</b></td>
		</tr>
		<c:forEach var="rList" items="${restaurantsList}">
				<tr>
					<td>${rList.rId}</td>
					<td>${rList.rName}</td>
					<td>${rList.rAddress}</td>
					<td>${rList.rNumber}</td>
					<td><a href="${contextPath}/viewitem?restaurantid=${rList.rId}&rname=${rList.rName}">View Menu</a></td>
				</tr>
			</c:forEach>
		</form:form>
		</div>
</body>
</html>