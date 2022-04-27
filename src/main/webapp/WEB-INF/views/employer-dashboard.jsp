<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- main div covers entire page -->
	<div id="main">

		<!-- box div at the center of page with glassify effect -->
		<div id="container">
			<div id="form-text">

				<!-- displays guiding and greeting texts for the page -->
				<h2 id="form-greeting-header">
					Welcome <span id="last-word">User!</span>
				</h2>

				<div id="form-content-span">
					<span>Please signup or login as user to acess user dashboard</span>
				</div>
			</div>
			

			<!-- form box with flipping ability between login and signup -->
			<div id="form-content">
			<div class="flip-container">
			<div class="flipper" id="flipper">

                         <!-- front part of the flip box dsipays options to sinup -->
                        <div class="front">
                            <h1 class="title">Post a Job</h1>
                            
				<form:form action="process-jobposting" method = "POST" modelAttribute="jobPostingDTO">
					<form:input path="CompanyName" placeholder="Company Name" required="true" />
					<form:input path="JobName" placeholder="Job Title" required="true" />
					<form:textarea path="Description" placeholder="Description" required="true" />

					
					<p/> 
					<p/> 
			
					<input type="submit" value="Submit">
				</form:form>
				
				<a href = "/springsecurity/loginForm">Already have an account login</a>

			</div>
		</div>
		</div>
		</div>
		</div>
		
	</div>


</body>
</html>