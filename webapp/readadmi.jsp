<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
	<link rel="stylesheet" href="styles/stylecrud.css">
	<script src="js/script.js"></script>
</head>

<body>
	<h1>Selecciona un rol</h1>
	<select id="rol" onchange="mostrarCuadros()">
		<option value="ninguno">Selecciona un rol</option>
		<option value="visitante">Visitante</option>
		<option value="serviciosgenerales">Servicios Generales</option>
		<option value="psicologo">Psicologo</option>
		
	</select>
	<br>
	<br>
	<br>

	<div class="cuadro" id="visitante" style="display: none">
		<div id="cuadroEnBlanco"></div>
	</div>

	<div class="cuadro" id="serviciosgenerales" style="display: none">
		<div id="cuadroEnBlanco"></div>
	</div>
	
	<div class="cuadro" id="psicologo" style="display: none">
		<div id="cuadroEnBlanco"></div>
	</div>

</body>

</html>