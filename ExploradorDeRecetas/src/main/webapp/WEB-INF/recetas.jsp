<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recetas</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>

	<h1>Recetas: </h1>
	
	<ul>
		<c:forEach var="receta" items="${recetas}">
			<li>Nombre: ${receta}</li>
		</c:forEach>
	</ul>
</body>
</html>