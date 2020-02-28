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
<title>Add to Order</title>
</head>
<body>
<div class="container">
<div class="alert alert-info" role="alert">
		<h4 class="text-center">
			<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
			Add to Order
		</h4>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	 <h3>The following items has been added to your shopping cart successfully</h3>
	 <table border="0" cellpadding="5" cellspacing="5">
		<tr>	
			<td><b>Item Name</b></td>
			<td><b>Item Price</b></td>
		</tr>
		 <c:set var="i" value="${0}" />
          <c:forEach var="item" items="${sessionScope.cartitems}">
          <tr>
              <td><c:out value="${item.itemName}" /></td>
              <td><c:out value="${item.price}" /></td>
              <td><a href="${contextPath}/removeCart?index=${i}">Remove Item</a></td>
              <c:set var="i" value="${i+1}" />
              </tr>          
          </c:forEach> 
          </table>
	
	<form:form modelAttribute="orderdetails" action="${contextPath}/addCart" method="get" 
		class="form-horizontal">	
	<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" name="shop" class="btn btn-primary"
				value="Continue shopping" />
		</div>
		</form:form>
		
		</div>
		<a href="${contextPath}/placeOrder">Place Order</a>

</body>
</html>