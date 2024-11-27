<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/StyleDetalle.css">
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
	<div class="card">
        <ul>
            <li>Agregado por ${poema.creador.nombre} ${poema.creador.apellido}</li>
            <li>Autor <p>${poema.autor.nombre}</p></li>
            <li>Año <p>${poema.creacion}</p></li>
            <li>Letra <p>${poema.letra}</p></li>
        </ul>
    </div>
    <c:if test="${poema.creador.id == idUsuario}">
        <form action="/eliminar/${poema.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <button type="submit">Eliminar Poema</button>
        </form>
    </c:if>
</body>
</html>