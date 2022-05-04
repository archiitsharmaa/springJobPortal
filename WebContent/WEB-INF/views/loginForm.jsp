<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="<c:url value="./template/css/style.css" />" rel="stylesheet">
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
					<span>Please signup or login as user to acess the job portal</span>
				</div>
			</div>


			<!-- form box with flipping ability between login and signup -->
			<div id="form-content">
				<div class="flip-container">
					<div class="flipperLogin">

						<!-- front part of the flip box dsipays options to sinup -->
						<div class="front">

							<h1 class="title">Login</h1>
							<form:form method="POST" action="process-login">
								<input type="text" name="username" placeholder="Username"
									required />
								<input type="password" name="password" placeholder="Password"
									required />
								<input type="submit" value="Login" />
							</form:form>
							<br />
							<p />

							<c:if test="${param.error != null}">
								<i style="color: red">Invalid username or password</i>
							</c:if>

							<c:if test="${param.logout != null}">
								<i style="color: red">You are logged out</i>
							</c:if>
							<br />
							<p />

							<a href="/CustomerManager/">Dont have an account, Signup</a>


						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>