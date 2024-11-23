<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favoritos</title>
<link rel="stylesheet" href="/css/StyleFavoritos.css">
</head>
<body>
	<h1>Articulos</h1>
	<ul>
		<li><a href="/articulos">Todos los Articulos</a></li>
		<li><a href="/form/agregar">Agregar Articulo</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>

	<table>
		<thead>
			<th>Titulo</th>
			<th>Detalle</th>
			<th>Modificar</th>
			<th>Me gusta</th>
		</thead>
		<tbody>
			<c:forEach var="articulo" items="${favUsuario}">
				<tr>
					<td>${articulo.titulo}</td>
					<td><a href="/detalle/${articulo.id}">Ver</a></td>
					<td>
					<form:form action="/quitarFav/${articulo.id}" method="POST">
						<input type="hidden" name="_method" value="DELETE"/>
							<button style="font-size: 27px">&#9829;</button>
					</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>