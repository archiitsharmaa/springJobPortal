<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ApplyJob</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css">
</head>
<body>

<!-- main div covers entire page -->
	<div id="main">

		<!-- box div at the center of page with glassify effect -->
		<div id="container">
			<div id="form-text">

				<!-- displays guiding and greeting texts for the page -->
				<h2 id="form-greeting-header">
					Welcome <span id="last-word">Candidate!</span>
				</h2>

				<div id="form-content-span">
					<span>Please check details before we send your application</span>
				</div>
			</div>

			<!-- form box with flipping ability between login and signup -->
			<div id="form-content">
			<div class="flip-container">
			<div class="flipper" id="flipper">

                         <!-- front part of the flip box dsipays options to sinup -->
                        <div class="front">
                           
				<form:form action="process-jobapplication" method = "POST" modelAttribute="appliedJobs">
				
				
				<h2>Application : ${jobName}</h2>
	
				Job Id:
					<form:input path="jobid" value = "${id}" disabled="true" />
					<form:hidden path="jobid" value = "${id}" />
			    Candidate Username:
			    	<form:input path="candidateUsername" value = "${username}" disabled="true" />
					<form:hidden path="candidateUsername" value = "${username}" />	
				Candidate Email:
					<form:input path="candidateEmail" value = "${email}" disabled="true" />
					<form:hidden path="candidateEmail" value="${email}" />

				
					
					<p/> 
					<p/> 
			
					<input type="submit" value="Apply Job">
					<a href = "/CustomerManager/joblist?username=${username}&email=${email}">Go Back</a>
				</form:form>

			</div>
		</div>
		</div>
		</div>
		</div>
		
	</div>



</body>
</html>