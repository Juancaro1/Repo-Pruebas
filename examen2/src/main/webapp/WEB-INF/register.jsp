<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/StyleRegister.css">

<title>Registro</title>
</head>
<body>
    <footer>
    <h1>Poemas</h1>
	<ul>
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
	</ul>
	<h2>Registro:</h2>
	</footer>
	<form:form action="/register" method="POST" modelAttribute="usuario">
	
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre" type="text" required = "true"/>
		<form:errors path="nombre"/>
		
		
		<form:label path="apellido">Apellido:</form:label>
		<form:input path="apellido" type="text" required = "true"/>
		<form:errors path="apellido"/>
		
		
		<form:label path="email">Correo:</form:label>
		<form:input path="email" type="text" required = "true"/>
		<form:errors path="email"/>
		
		
		<form:label path="password">Contrasena:</form:label>
		<form:input path="password" type="text" required = "true"/>
		<form:errors path="password"/>
		
		
		<form:label path="confirmarPassword">Confirma la Contrasena:</form:label>
		<form:input path="confirmarPassword" type="text" required = "true"/>
		<form:errors path="confirmarPassword"/>
		
		<input type="submit" value="Registrarse"/>
	
	</form:form>
</body>
</html>