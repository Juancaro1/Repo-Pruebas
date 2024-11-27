<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Poemas</title>
<link rel="stylesheet" href="/css/StylePoemas.css">
</head>
<body>
	<footer>
	<h1>Poemas</h1>
	<ul>
		<li><a href="/poemas">Todos Los poemas</a></li>
		<li><a href="/form/agregar">Agregar poema</a></li>
        <li><a href="/logout">Logout</a></li> 
	</ul>
	</footer>

	<div>
		<ul>
			<c:forEach var="poema" items="${poemas}">
				<li>
					<h3>${poema.titulo}</h3>
					<div class="poema-info">
						<p><strong>Autor:</strong> <a href="/poemas/autor/${poema.autor.id}">${poema.autor.nombre}</a></p>
						<p><strong>Agregado por:</strong> ${poema.creador.nombre} ${poema.creador.apellido}</p>
						<p><strong>Año:</strong> ${poema.creacion}</p>
					</div>
					<a href="/form/editar/${poema.id}">Editar</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
