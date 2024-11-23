<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articulos</title>
<link rel="stylesheet" href="/css/Styles.css">
</head>
<body>
	<footer>
	<h1>Articulos</h1>
	<ul>
		<li><a href="/articulos">Todos los Articulos</a></li>
		<li><a href="/form/agregar">Agregar Articulo</a> </li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	</footer>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>
	
	<table>
		<thead>
			<th>Titulo</th>
			<th>Detalle</th>
			<th>Modificar</th>
			<th>Me gusta</th>
		</thead>
		<tbody>
		<c:forEach var="articulo" items="${articulos}">
			<tr>
				<td>${articulo.titulo}</td>
				<td><a href="/detalle/${articulo.id}">Ver</a></td>
				<td>
					<c:if test="${articulo.creador.id == idUsuario}">
						<a href="/form/editar/${articulo.id}">Editar</a>
					</c:if>
				</td>
				<td>
				<c:if test="${fn:length(favUsuario) > 0}">
                <c:forEach var="articuloUsuario" items="${favUsuario}">
                    <c:if test="${articuloUsuario.id == articulo.id}">
                        <form:form action="/quitarFav/${articulo.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE"/>
                            <button style="font-size: 27px">&#9829;</button> 
                        </form:form>
                    </c:if>
                    <c:if test="${articuloUsuario.id != articulo.id}">
                        <form:form action="/agregarFav/${articulo.id}" method="POST">
                            <button style="font-size: 27px">&#9825;</button> 
                        </form:form>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${fn:length(favUsuario) == 0}">
                <form:form action="/agregarFav/${articulo.id}" method="POST">
                    <button style="font-size: 27px">&#9825;</button>
                </form:form>
            </c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>