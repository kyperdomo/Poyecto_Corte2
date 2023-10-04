<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Users</title>
<link rel="stylesheet" href="styles/styleuser.css">
<link href="'https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;500;600;700;800;900&display=swap'">
</head>
<body>
<!--parial:index.partial.html-->
<div class="container">
	<a href="sesionvis.jsp" style="--color: #1e9bff"> <span>Visitante</span><i></i> </a>
	<a href="sesionpsy.jsp" style="--color: #ff1867"> <span>Psicologo</span><i></i> </a>
	<a href="sesionadmin.jsp" style="--color: #6eff3e"> <span>Administrador</span><i></i> </a>
	<a href="sesiongen.jsp" style="--color: #6eff3e"> <span>Servicios Generales</span><i></i> </a>
<!--partial-->
</div>
</body>
</html>