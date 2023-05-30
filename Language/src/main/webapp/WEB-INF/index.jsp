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
	<div class= "container m-3">
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Creator</th>
		      <th scope="col">Version</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="language" items="${languages }">
				<tr>
					<th scope="row"><c:out value="${language.id }"></c:out></th>
					<td> <a href="/detail/${language.getId()}"><c:out value="${language.getName() }"></c:out></a></td>
					<td><c:out value="${language.getCreator() }"></c:out></td>
					<td><c:out value="${language.getCurrentVersion() }"></c:out></td>
					<td><a class="btn btn-outline-info" href="/edit/${language.getId()}" role="button">Edit</a>
		      		<a class="btn btn-outline-danger" href="/delete/${language.id}" role="button">Delete</a>
		      		</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		
		<form:form action="/new" method="post" modelAttribute="language">
			<div class="row mb-3">
				<form:errors class="text-danger" path="currentVersion"></form:errors>
			</div>
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">Name</label>
		    <div class="col-sm-10">
		      <form:input path="name" type="text" class="form-control" id="name" placeholder="Name"/>
		    </div>
		    <form:errors class="text-danger" path="name"></form:errors>
		  </div>
		  
		  <div class="form-group row">
		    <label for="creator" class="col-sm-2 col-form-label">Creator</label>
		    <div class="col-sm-10">
		      <form:input path="creator" type="text" class="form-control" id="creator" placeholder="creator"/>
		    </div>
		    <form:errors class="text-danger" path="creator"></form:errors>
		  
		  </div>
		  
		  <div class="form-group row">
		    <label for="version" class="col-sm-2 col-form-label">Version</label>
		    <div class="col-sm-10">
		      <form:input path="currentVersion" type="number" class="form-control" id="version" placeholder="Version"/>
		    </div>
		    <form:errors class="text-danger" path="currentVersion"></form:errors>
		  </div>
		 
		  <div class="form-group row">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-primary">Submit</button>
		    </div>
		  </div>
		  
		</form:form>
		
	</div>
</body>
</html>