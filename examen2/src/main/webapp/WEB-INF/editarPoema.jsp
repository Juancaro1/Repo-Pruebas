<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="/css/StyleEditar.css">
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

	<form:form action="/actualizar/${poema.id}" method="POST" modelAttribute="poema">
        <input type="hidden" name="_method" value="PUT">
	
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

		<input type="submit" value="Editar"/>
	</form:form>
</body>
</html>