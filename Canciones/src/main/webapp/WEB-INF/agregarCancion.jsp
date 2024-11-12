<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
	<h1>Formulario para agregar canciones</h1>
		<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
			<form:label path="titulo">Titulo:</form:label>
			<form:input type="text" path="titulo"/>
			<form:errors path="titulo"/>
			
			<form:label path="artista">Artista:</form:label>
			<form:input type="text" path="artista"/>
			<form:errors path="artista"/>
			
			<form:label path="album">Album:</form:label>
			<form:input type="text" path="album"/>
			<form:errors path="album"/>
			
			<form:label path="genero">Genero:</form:label>
			<form:input type="text" path="genero"/>
			<form:errors path="genero"/>
			
			<form:label path="idioma">Idioma:</form:label>
			<form:input type="text" path="idioma"/>
			<form:errors path="idioma"/>
			
			<button type="submit">agregar</button>
		
		</form:form>
		<a href="/canciones">Volver a la lista</a>
</body>
</html>