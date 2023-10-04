<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Concert One">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet" />
<link rel="stylesheet" href="styles/datavis.css" />
</head>
<body>
	<form action="alcoholiccontrollerservlet" method="get">
		<div class="input-group">
			<h2>Visitor</h2>
			<br> <input type="text" placeholder="Name" name="name" /> <label
				for="name"></label> <br> <br> 
				<input type="text"
				placeholder="Born date (yyyy/mm/dd)" name="fechaNacimiento" /> 
				<label
				for="fechaNacimiento"></label> <br> <br> <input
				name="DocIdentidad" type="text"
				placeholder="Identification document" maxlength="10" /> <label for="DocIdentidad"></label> <br> <br>
			<input type="text" placeholder="City of birth" name="CiudadNac" /> <label
				for="CiudadNac"></label> <br> <br> <input type="text"
				placeholder="Sessions attended" name="SesionPar" /> <label
				for="SesionPar"></label> <br> <br> <input type="text"
				placeholder="Nickname" name="Apodo" /> <label for="Apodo"></label> <br>
			<input name= "action" class="button1" type="submit" value="upload information">
			
			
			<br> <input name= "action" class="button2" type="submit" value="save">
			<a class="button button2" href="index.jsp"> <span>Discard</span><i></i></a>


		</div>
	</form>
</body>
</html>