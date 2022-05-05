<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css">
</head>
<body>

	<!-- main div covers entire page -->
	<div id="main">

		<!-- box div at the center of page with glassify effect -->
		<div id="searchUser-container">
			
			
			<div>

				<!-- div contaning navbar to navigate across the dashboard -->
				<div class="navbar" id="navbar">

					<a href="/CustomerManager/welcome"> <i class="fas fa-home"></i>
						Home
					</a>

					<sec:authorize access='hasAuthority("Employer")'>
						<a
							href="/CustomerManager/postJob?username=${username}&email=${email}">
							<i class="fas fa-sticky-note"></i> Post Jobs
						</a>
					</sec:authorize>

					<a
						href="/CustomerManager/joblist?username=${username}&email=${email}">
						<i class='fas fa-list'></i> Job Market Place
					</a>
					
					<sec:authorize access='hasAuthority("Employer")'>
						<a href="/CustomerManager/postedJobs?username=${username}&email=${email}">
						<i class="fas fa-check-square"></i> My Jobs</a>
					</sec:authorize>


					<!-- logouts the users by destroying current user instance in local storage and redirectiong to index.html -->

					<form:form action="logout" method="POST" id="last-tag">
						<input type="submit" value="logout">
					</form:form>

				</div>
			</div>
				
				<h2>Applications for ${jobName}</h2>
			
			<table id="displayTable" style="margin-top: auto; margin-bottom: auto;">
					<tr>
					 <th>Candiate Id</th> 
					 <th>CandidateUsername</th>
						<th>CandidateEmail</th> 
						<th>Job Id</th>
					
					</tr>

					<c:forEach items="${values}" var="jobs">
						<tr>
							<td>${jobs.id}</td>
							<td>${jobs.candidateUsername}</td>
							<td>${jobs.candidateEmail}</td>
							<td>${jobs.jobid}</td>

		

							
						</tr>
					</c:forEach>

				</table>


		</div>
	</div>
</body>
</html>