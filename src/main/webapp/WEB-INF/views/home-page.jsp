<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> hellooooon world </h1>

<h1> hi ${username}</h1>

<h4> roles : ${roles}</h4>


<sec:authorize access = 'hasAuthority("Employer")'>
<a href = "/springsecurity/employer">Show Employer Dashbaord</a>
</sec:authorize>

<sec:authorize access='hasAuthority("Job Seeker")'>
<a href = "/springsecurity/candidate">Show candiate Dashbaord</a>
</sec:authorize>

<span sec:authentication="principal.email">Email</span>

 
<form:form action = "logout" method = "POST">
	<input type = "submit" value = "logout">
</form:form>

</body>
</html>