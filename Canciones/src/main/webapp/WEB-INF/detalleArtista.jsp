	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
    <h1>Detalle de ${artista.nombre}</h1>
    
    <ul>
    <li>Nombre: ${artista.nombre}</li>
    <li>Apellido: ${artista.apellido}</li>
    <li> Biografia: ${artista.biografia}</li>
    <li>Fecha de creacion: ${artista.fecha_creacion}</li>
    <li>fecha de actualizacion: ${artista.fecha_actualizacion}</li>
    </ul>

    <ul>
        <c:forEach var="cancion" items="${artista.listaCanciones}">
            <li>Cancion: ${cancion.titulo}</li>
        </c:forEach>
    </ul>
    
    <form action="/artistas/eliminar/${artista.id}" method="POST">
	<input type="hidden" name="_method" value="DELETE">
    <button type="submit">Eliminar Artista</button>
	</form>

    <a href="/artistas">volver a la lista de canciones</a>
</body>
</html>