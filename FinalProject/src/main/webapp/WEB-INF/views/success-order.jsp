<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<h1>Order placed successfully.</h1><br/><br/>
<a href="${contextPath}/report">Download Pdf</a><br/>
<a href="${contextPath}/logout">Logout</a>
</body>
</html>