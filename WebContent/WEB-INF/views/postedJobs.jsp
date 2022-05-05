<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Posted Jobs</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css">
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

			
			<table id="displayTable"
				style="margin-top: auto; margin-bottom: auto;">
				<tr class="header">
					<th>ID</th>
					<th>JobName</th>
					<th>CompanyName</th>
					<th>Job Description</th>
					<th>EmployerUsername</th>
					<th>EmployerEmail</th>
					<sec:authorize access='hasAuthority("Employer")'>
						<th>Action</th>
					</sec:authorize>
				</tr>

				<c:forEach items="${postedJobs}" var="jobs">
					<tr>
						<td>${jobs.id}</td>
						<td>${jobs.jobName}</td>
						<td>${jobs.companyName}</td>
						<td>${jobs.description}</td>
						<td>${jobs.employerUsername}</td>
						<td>${jobs.employerEmail}</td>

						<sec:authorize access='hasAuthority("Employer")'>
							<td><a class = "button"
								href="/CustomerManager/candidateList?username=${username}&email=${email}&id=${jobs.id}&name=${jobs.jobName}">
								Candiate List</a>
								<p/>
								<a class = "button"
								href="/CustomerManager/deleteJob?username=${username}&email=${email}&id=${jobs.id}">
								Delete Posting</a>
								<p/>
								<a class = "button"
								href="/CustomerManager/updateJobPosting?username=${username}&email=${email}&jobid=${jobs.id}&jobName=${jobs.jobName}&companyName=${jobs.companyName}&description=${jobs.description}">
								Edit Posting</a>
							</td>

						</sec:authorize>
						
						
					</tr>
				</c:forEach>

			</table>


		</div>
	</div>


</body>
</html>