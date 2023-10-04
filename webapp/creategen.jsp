<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crear</title>
	<link rel="stylesheet" href="styles/stylecrud.css">
	<script src="js/script.js"></script>
</head>

<body>
	<h1>Selecciona un rol</h1>
	<select id="rol" onchange="mostrarCuadros()">
		<option value="ninguno">Selecciona un rol</option>
		<option value="visitante">Visitante</option>
	</select>
	<br>
	<br>
	<br>

	<div class="cuadro" id="visitante" style="display: none">
		<label for="nombre">Nombre:</label>
		<input type="text" id="nombre" name="nombre">
		<br>
		<br>
		<label for="fecha">Fecha de Nacimiento:</label>
		<input type="text" id="fecha" name="fecha">
		<br>
		<br>
		<label for="cedula">Cedula:</label>
		<input type="text" id="cedula" name="cedula" maxlength="10">
		<br>
		<br>
		<label for="ciudad">Ciudad:</label>
		<input type="text" id="ciudad" name="ciudad">
		<br>
		<br>
		<label for="sesionespar">Sesiones participadas:</label>
		<input type="text" id="sesionespar" name="sesionespar">
		<br>
		<br>
		<label for="apodo">Apodo:</label>
		<input type="text" id="apodo" name="apodo">
		<br>
		<br>
		<button class="button button1">Save</button>
		<button class="button button2">Discard</button>
	</div>

</body>

</html>