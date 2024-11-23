<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Articulo</title>
<link rel="stylesheet" href="/css/StyleAgregar.css">
</head>
<body>
<h1>Articulos</h1>
	<footer>
	<ul>
		<li><a href="/articulos">Todos Los articulos</a></li>
		<li><a href="/form/agregar">Agregar Articulo</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	</footer>
	<h2>Agregar Articulo:</h2>
	<form:form action="/guardar" method="POST" modelAttribute="articulo">

		<form:label path="titulo">Titulo:</form:label>
		<form:input path="titulo" type="text"/>
		<form:errors path="titulo"/>
		
		
		<form:label path="descripcion">Descripcion:</form:label>
		<form:textarea path="descripcion"/>
		<form:errors path="descripcion"/>
		
	
		<form:label path="categoria">Categoria:</form:label>
		<form:input path="categoria" type="text"/>
		<form:errors path="categoria"/>

		<input type="hidden" name="creador" value="${creador.id}">
	<input type="submit" value="Agregar"/>
	</form:form>
</body>
</html>