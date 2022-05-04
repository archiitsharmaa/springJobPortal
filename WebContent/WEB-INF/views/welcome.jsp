<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome,${customer.username}</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css">
</head>
<body>
	<!-- main div covers entire page -->
	<div id="main">
		<!-- box div at the center of page with glassify effect -->
		<div id="admin-container">
			<div>

				<!-- div contaning navbar to navigate across the dashboard -->
				<div class="navbar" id="navbar">
				
					<a href="/CustomerManager/welcome">
					<i class="fas fa-home"></i> Home</a> 

					<sec:authorize access='hasAuthority("Employer")'>
						<a href="/CustomerManager/postJob?username=${customer.username}&email=${customer.email}">
						<i class="fas fa-sticky-note"></i> Post Jobs</a>
					</sec:authorize>

					<a href="/CustomerManager/joblist?username=${customer.username}&email=${customer.email}">
					<i class='fas fa-list'></i> All Jobs</a> 
					
					<sec:authorize access='hasAuthority("Employer")'>
						<a href="/CustomerManager/postedJobs?username=${customer.username}&email=${customer.email}&id=${customer.id}">
						<i class="fas fa-check-square"></i> My Jobs</a>
					</sec:authorize>
				
		

					<!-- logouts the users by destroying current user instance in local storage and redirectiong to index.html -->
					
					<form:form action="logout" method="POST" id="last-tag">
					<input type="submit" value="logout" >
				</form:form>

				</div>
			</div>

			<!-- dashboard contents -->
			<div id="admin-dashboard-welcome">

				
				<h1>Hi, ${customer.name}</h1>
				<!-- displaying details of current account -->
				<p>The details of this accounts are as follows.</p>
				<h2>
					Name : ${customer.name} <br> Username : ${customer.username} <br>
					email : ${customer.email} <br> Role : ${customer.role} <br>
					Phone : ${customer.phone}
				</h2>
			</div>
		</div>

	</div>
</body>
</html>