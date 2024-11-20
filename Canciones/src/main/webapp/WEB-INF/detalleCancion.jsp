<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
	<h1>Detalles de la cancion: ${cancion.titulo}</h1>
	
	<ul>
		<li>Titulo: ${cancion.titulo}</li>
		<li>Artista: ${cancion.artista.nombre}</li>
		<li>Album: ${cancion.album}</li>
		<li>Genero: ${cancion.genero}</li>
		<li>Idioma: ${cancion.idioma}</li>
	</ul>

	<a href="/canciones/formulario/editar/${cancion.id}">Editar Cancion<a>
	<br>

	<form action="/canciones/eliminar/${cancion.id}" method="POST">
	<input type="hidden" name="_method" value="DELETE">
    <button type="submit">Eliminar Canción</button>
	</form>
	
	<a href="/canciones">Volver a la lista de canciones</a>
	
	
</body>
</html>