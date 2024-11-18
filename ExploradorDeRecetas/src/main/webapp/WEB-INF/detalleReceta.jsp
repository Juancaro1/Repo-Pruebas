<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de la receta</title>
<link rel="stylesheet" href="/static/css/styles.css">

</head>
<body>

	<h1>Detalle de la receta: ${nombreReceta}</h1>
	
	<c:if test="${mensajeError != null}">
		<p>${mensajeError}</p>
	</c:if>
	
	<c:if test="${mensajeError == null}">
		<h2>Ingredientes de la receta:</h2>
		<ul>
		<c:forEach var="ingrediente" items="${ingredientes}">
			<li>${ingrediente}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<a href="/recetas">Volver a la listas de recetas.</a>
</body>
</html>