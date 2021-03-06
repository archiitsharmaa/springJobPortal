<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Job</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css">
</head>
<body>

	<!-- main div covers entire page -->
	<div id="main">
		<!-- box div at the center of page with glassify effect -->
		<div id="update-container">

			<div>
				<!-- div contaning navbar to navigate across the dashboard -->
				<div class=" navbar" id="navbar">

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

			<div>

			Welcome ${username}, Please Post the according to the feilds
			

				<div id="form-content">
					<div class="flip-container">
						<div class="flipper" id="flipper">

							<!-- front part of the flip box dsipays options to sinup -->
							<div class="front">

								<h1 class="title">Post a Job</h1>

								<form:form action="processjobUpdating/?username=${username}&email=${email}" method="POST"
									modelAttribute="postedJobs">

									<form:hidden path="employerUsername" value="${username}" />

									<form:hidden path="employerEmail" value="${email}" />
									<form:hidden path="id" value="${jobid}" />

									<form:input path="CompanyName" placeholder="Company Name"
										default = "${companyname}" required="true" />
									<form:input path="JobName" placeholder="Job Title"
										default = "${jobname}" required="true" />
									<form:textarea path="Description" placeholder="Description"
										default = "${description}" required="true" />


									<p />
									<p />

									<input type="submit" value="Post Job">
								</form:form>

							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
		</div>
</body>
</html>