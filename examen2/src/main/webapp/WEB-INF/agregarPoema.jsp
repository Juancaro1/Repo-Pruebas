<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="/css/StyleAgregar.css">
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

	<form:form action="/guardar" method="POST" modelAttribute="poema">
	
		<form:label path="titulo">Titulo:</form:label>
		<form:input path="titulo" type="text" required = "true"/>
		<form:errors path="titulo"/>
		
		
		<form:label path="autor">Autor:</form:label>
		<form:input path="autor.nombre" type="text" required = "true"/>
		<form:errors path="autor.nombre"/>
		
		
		<form:label path="creacion">Año:</form:label>
		<form:input path="creacion" type="text" required = "true"/>
		<form:errors path="creacion"/>
		
		
		<form:label path="letra">Letra:</form:label>
		<form:input path="letra" type="text" required = "true"/>
		<form:errors path="letra"/>

		<input type="submit" value="Agregar"/>
	</form:form>
</body>
</html>