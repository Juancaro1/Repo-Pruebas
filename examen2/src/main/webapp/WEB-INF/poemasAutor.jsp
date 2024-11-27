<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Poemas de ${autor.nombre}</title>
    <link rel="stylesheet" href="/css/StylePoemasAutor.css">
</head>
<body>

    <footer>
        <h1>Poemas</h1>
        <ul>
            <li><a href="/poemas">Todos los poemas</a></li>
            <li><a href="/form/agregar">Agregar poema</a></li>
            <li><a href="/logout">Logout</a></li> 
        </ul>
    </footer>

    <h2>Poemas de ${autor.nombre}</h2>

    <div class="poemas-list">
    <c:if test="${not empty poemas}">
        <table>
            <thead>
                <tr>
                    <th>Poema</th>
                    <th>Detalle</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="poema" items="${poemas}">
                    <tr>
                        <td>${poema.titulo} - Creado el: ${poema.creacion}</td>
                        <td><a href="/detalle/${poema.id}"><button>Ver</button></a></td> <!-- Botón para ver detalles -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty poemas}">
        <p class="centro">No hay poemas para este autor.</p>
    </c:if>
</div>

</body>
</html>
