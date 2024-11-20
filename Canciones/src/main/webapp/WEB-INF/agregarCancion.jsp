<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
    <link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
    <h1>Agrega una nueva canción</h1>

    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        
    
        <form:label path="titulo">Título:</form:label>
        <form:input path="titulo"/>
        <form:errors path="titulo"/>

        <form:label path="artista">Artista:</form:label>
        <form:select path="artista">
            <c:forEach var="artista" items="${artistas}">
                <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
            </c:forEach>
            </form:select>
        <form:errors path="artista"/>

        <form:label path="album">Álbum:</form:label>
        <form:input path="album"/>
        <form:errors path="album"/>

        <form:label path="genero">Género:</form:label>
        <form:input path="genero"/>
        <form:errors path="genero"/>

        <form:label path="idioma">Idioma:</form:label>
        <form:input path="idioma"/>
        <form:errors path="idioma"/>

        <button type="submit">Agregar Canción</button>
    </form:form>

    <a href="/canciones">Volver a la lista de canciones</a>
</body>
</html>
