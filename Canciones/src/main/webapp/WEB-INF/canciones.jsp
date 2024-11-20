	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canciones</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
	<h1>Estas son las canciones</h1>
		
        <ul>
            <c:forEach var="cancion" items="${canciones}">
            <li>Titulo: ${cancion.titulo}</li>
            <li>Artista: ${cancion.artista.nombre}</li>

            <a href="/canciones/detalle/${cancion.id}">detalles</a>
            </c:forEach>
        </ul>

        <a href="/canciones/formulario/agregar">Agregar Cancion</a>
        <br>
        <a href="/artistas">Ir a artistas</a>
</body>
</html>