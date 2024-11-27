<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/StyleLogin.css">
</head>
<body>
	<footer>
	<h1>Poemas</h1>
	<ul>
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
	</ul>
	</footer>

	<div class="card">
		<h2>Login</h2>
		<form:form action="/login" method="POST" modelAttribute="loginUsuario">
	
			<form:label path="email">Correo</form:label>
			<form:input path="email" type="text" required="true"/>
			<form:errors path="email" />
		
			<form:label path="password">Contraseña</form:label>
			<form:input path="password" type="password" required="true"/>
			<form:errors path="password" />
		
			<input type="submit" value="Login"/>
		</form:form>
	</div>

</body>
</html>
