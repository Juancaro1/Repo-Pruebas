<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros Disponibles</title>
</head>
<body>
	<h1>Libros disponibles:</h1>
		 <ul>
		 <c:forEach var="libro" items="${libros}">
				<li>Nombre: ${libro.key}</li>
				<li>Autor: ${libro.value}</li>
				<a href="/libros/${libro.key}"><br>Detalles</a> 
				</c:forEach>
		</ul>
		 <a href="/libros/formulario">Agregar Libro</a>
</body>
</html>