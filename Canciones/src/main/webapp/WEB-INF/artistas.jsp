	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artistas</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>

    <h1>Artistas: </h1>

    <ul>
        <c:forEach var="artista" items="${artistas}">
            <li><a href="/artistas/detalle/${artista.id}"> Nombre: ${artista.nombre}, Apellido: ${artista.apellido}</a></li>
        </c:forEach>
    </ul>
    <br>
    <a href="/artistas/formulario/agregar/">Agregar Artista</a>
    <br>
    <a href="/canciones">Ir a canciones</a>
</body>
</html>