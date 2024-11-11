<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
	<h1>Formulario:</h1>
	
		<form action="/procesa/libro" method="POST"> 
			<label for="nombreLibro">Nombre del libro: </label>
			<input type="text" name="nombreLibro" />
		
			<label for="autorLibro">Autor del Libro: </label>
			<input type="text" name="autorLibro"/>
		
			<button type="submit">Agregar</button>
		</form>
		
</body>
</html>