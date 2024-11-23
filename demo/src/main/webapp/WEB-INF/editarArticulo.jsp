<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Articulo</title>
<link rel="stylesheet" href="/css/StyleEditar.css">
</head>
<body>
	<footer>
		<h1>Articulos</h1>
		<ul>
			<li><a href="/articulos">Todos los Articulos</a></li>
			<li><a href="/form/agregar">Agregar Articulo</a></li>
			<li><a href="/logout">Logout</a></li>
		</ul>
	</footer>
	<h2>Editar articulo:</h2>
	<form:form action="/actualizar/${articulo.id}" method="POST" modelAttribute="articulo">
		<input type="hidden" name="_method" value="PUT">
		
		<form:label path="titulo">Titulo:</form:label>
		<form:input path="titulo" type="text"/>
		<form:errors path="titulo"/>
		
		<form:label path="descripcion">Descripcion:</form:label>
		<form:textarea path="descripcion"/>
		<form:errors path="descripcion"/>
	
		<form:label path="categoria">Categoria/Tema:</form:label>
		<form:input path="categoria" type="text"/>
		<form:errors path="categoria"/>
		
		<input type="submit" value="Editar"/>
	</form:form>
</body>
</html>