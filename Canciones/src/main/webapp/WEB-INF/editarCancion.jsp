<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar cancion</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
	<h1>Editar: ${cancion.titulo}</h1>

	<form:form action="/canciones/procesa/editar/${cancion.id}"
		method="POST" modelAttribute="cancion">
		<input type="hidden" name="_method" value="PUT">

		<form:label path="titulo">Título:</form:label>
		<form:input type="text" path="titulo" id="artista" required="true" />


		<form:label path="artista">Artista:</form:label>
		<form:input type="text" path="artista" id="artista" required="true" />


		<form:label path="album">Álbum:</form:label>
		<form:input type="text" path="album" id="album" required="true" />


		<form:label path="genero">Género:</form:label>
		<form:input type="text" path="genero" id="genero" required="true" />


		<form:label path="idioma">Idioma:</form:label>
		<form:input type="text" path="idioma" id="idioma" required="true" />


		<button type="submit">Actualizar Cancion</button>
	</form:form>

	<a href="/canciones">Volver a la lista de canciones</a>
</body>
</html>