<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language API</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1> <c:out value="${language.name }"></c:out></h1>
	<p> Name:  <c:out value="${language.name }"></c:out></p>
	<p> Creator: <c:out value="${language.creator }"></c:out></p>
	<p> Version:  <c:out value="${language.currentVersion }"></c:out></p>

<a class="btn btn-outline-info" href="/edit/${language.getId()}" role="button">Edit</a>
		      		<a class="btn btn-outline-danger" href="/delete/${language.id}" role="button">Delete</a>
</body>
</html>