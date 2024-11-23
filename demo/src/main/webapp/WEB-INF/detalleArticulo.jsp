<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/StyleDetalle.css">
    <title>Detalle del Artículo</title>
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
    <h2>${articulo.titulo}</h2>

    <div>
        <p>Artículo creado por:</p>
        <ul>
            <li>${articulo.creador.nombre} ${articulo.creador.apellido}</li>
        </ul>

        <p>Categoría/Tema:</p>
        <ul>
            <li>${articulo.categoria}</li>
        </ul>

        <p>Descripción:</p>
        <ul>
            <li>${articulo.descripcion}</li>
        </ul>
    </div>

        <c:if test="${articulo.creador.id != null && idUsuario != null && articulo.creador.id == idUsuario}">
            <form action="/eliminar/${articulo.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button type="submit">Eliminar artículo</button>
            </form>
        </c:if>
</body>
</html>
