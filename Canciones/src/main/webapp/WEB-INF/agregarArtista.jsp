<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Artista</title>
    <link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
    <h1>Agrega un nuevo artista</h1>

    <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="nuevoArtista">
    
        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre"/>
        <form:errors path="nombre"/>

        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido"/>
        <form:errors path="apellido"/>

        <form:label path="biografia">Biografia:</form:label>
        <form:textarea path="biografia" rows= "5" cols="50"/>
        <form:errors path="biografia"/>

        <button type="submit">Agregar artista</button>
        <br>
    </form:form>

    <a href="/canciones">Volver a la lista de canciones</a>
</body>
</html>
