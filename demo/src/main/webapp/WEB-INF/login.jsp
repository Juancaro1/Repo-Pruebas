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
	<h1>Articulos</h1>
	<ul>
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
	</ul>
	</footer>
	<h2>Login</h2>
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">
	
		<form:label path="email">Correo</form:label>
		<form:input path="email" type="text"/>
		<form:errors path="email"/>
	
		<form:label path="password">Contrasena</form:label>
		<form:input path="password" type="password" />
		<form:errors path="password"/>
	
		<input type="submit" value="Login"/>
	</form:form>
	
</body>
</html>