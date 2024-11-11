	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles</title>
</head>
<body>
	<h1>Detalle del libro:</h1>
	
	<c:if test="${mensaje == null}">
		<ul>
        	<li>Nombre del Libro: ${nombre}</li>
        	<li>Autor: ${autor}</li>
        </ul>
    </c:if>
    
		<c:if test="${mensaje != null}">
        <p>${mensaje}</p>
    	</c:if>

    <a href="/libros">Volver a la lista de libros</a>
</body>
</html>