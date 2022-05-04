<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
<script src="./template/js/validations.js"></script>
</head>
<body>


	<!-- main div covers entire page -->
	<div id="main">

		<!-- box div at the center of page with glassify effect -->
		<div id="container">
			<div id="form-text">

				<!-- displays guiding and greeting texts for the page -->
				<h2 id="form-greeting-header">
					Welcome to <span id="last-word">Jobzz!</span>
				</h2>

				<div id="form-content-span">
					<span>Please signup or login to acess the job portal</span>
				</div>
			</div>


			<!-- form box with flipping ability between login and signup -->
			<div id="form-content">
				<div class="flip-container">
					<div class="flipper" id="flipper">

						<!-- front part of the flip box dsipays options to sinup -->
						<div class="front">
							<h1 class="title">Register</h1>
							<form:form action="save" method="post" 
							modelAttribute="customer" onsubmit="return validateForm()">
							
								<div>
								<form:input path="name" placeholder="Full Name" required="true"
								oninput="validateFullName()" id="full_name"/>
								</div>
						
						
								<div id="emailDiv" class="input-control">
				<form:input path="email" placeholder="email" id="email" name="email"
					oninput="validateEmail()" required="true"/>
				<div class="error" id="emailError"><form:errors path="email" cssStyle="color:#ff3860"></form:errors></div>
			</div>
								
								<div id="numberDiv" class="input-control">
				<form:input path="Phone" placeholder="Phone number" id="number"
					name="number" oninput="validateNumber()" required="true"/>
				<div class="error" id="numberError"><form:errors path="phone" cssStyle="color:#ff3860"></form:errors></div>
			</div>
								<form:input path="username" placeholder="Username"
									required="true" />
								<c:if test="${param.exists != null}">
									<i style="color: red">Username Already Exists</i>
								</c:if>
								<div id="passwordDiv" class="input-control">
				<form:password path="password" id="password" name="password"
					placeholder="Password" oninput="validatePassword()" required="true"/>
				<div id="passwordError" class="error"><form:errors path="password" cssStyle="color:#ff3860"></form:errors></div>
			</div>
						
					Please Select the role	
					<form:select path="role" required="true">
									<option value="" disabled selected>Choose User Type</option>
									<form:option value="Job Seeker"></form:option>
									<form:option value="Employer"></form:option>
								</form:select>

								<p />
								<p />

								<input type="submit" value="Register">
							</form:form>

							<a href="/CustomerManager/loginForm">Already have an account
								login</a>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>