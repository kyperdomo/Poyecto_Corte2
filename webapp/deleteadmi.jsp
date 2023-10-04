<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
	<link rel="styles/stylesheet" href="styles/stylecrud.css">
	<script src="js/script.js"></script>
</head>

<body>
	<h1>Selecciona el rol a eliminar</h1>
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
		<label for="cedula">Cedula:</label>
		<input type="text" id="cedula" name="cedula" maxlength="10">
		<br>
		<br>
		<button class="button button1">Delete</button>
		<button class="button button2">Discard</button>
	</div>
	
	<div class="cuadro" id="serviciosgenerales" style="display: none">
		<label for="cedula">Cedula:</label>
		<input type="text" id="cedula" name="cedula" maxlength="10">
		<br>
		<br>
		<button class="button button1">Delete</button>
		<button class="button button2">Discard</button>
	</div>
	
	<div class="cuadro" id="psicologo" style="display: none">
		<label for="cedula">Cedula:</label>
		<input type="text" id="cedula" name="cedula" maxlength="10">
		<br>
		<br>
		<button class="button button1">Delete</button>
		<button class="button button2">Discard</button>
	</div>

</body>

</html>