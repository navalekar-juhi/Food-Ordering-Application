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
<title>View Items</title>
</head>
<body>
	<div class="container">
		<div class="alert alert-info" role="alert">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
				View Menu
			</h4>
		</div>
		<h2>Welcome ${user.userName}</h2>
		<h2>${sessionScope.restaurantName}</h2>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<table border="1" cellpadding="5" cellspacing="5">
				<tr>
					<td><b>Item Id</b></td>
					<td><b>Item Name</b></td>
					<td><b>Item Price</b></td>
					<td><b>Option</b></td>
				</tr>
		<c:forEach var="rList" items="${itemList}">
					<form:form action="${contextPath}/addCart" method="post" modelAttribute="orderdetails">
						<tr>
							<td><form:input type="text" path="itemId" value="${rList.itemId}" readonly="true"/></td>
							<td><form:input type="text"  path="itemName" value="${rList.itemName}" readonly="true"/></td>
							<td><form:input type="text" path="price" value="${rList.itemPrice}" readonly="true"/></td>
								<td><input type="submit" value="add to cart"/><br/></td>						
						</tr>
					</form:form>
		</c:forEach>
		</table>
		</div>
</body>
</html>