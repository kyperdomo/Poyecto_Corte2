<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Update</title>
	<link rel="stylesheet" href="styles/stylecrud.css">
	<script src="js/script.js"></script>
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="cuadro" id="serviciosgenerales">
		<label for="nombre">Nombre:</label>
		<input type="text" id="nombre" name="nombre">
		<br>
		<br>
		<label for="fechanac">Fecha de Nacimiento:</label>
		<input type="text" id="fechanac" name="fechanac">
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
		<label for="salario">Salario:</label>
		<input type="text" id="salario" name="salario">
		<br>
		<br>
		<label for="sesioneslimp">Sesiones limpiadas:</label>
		<input type="text" id="sesioneslimp" name="sesioneslimp">
		<br>
		<br>
		<button class="button button1">Save</button>
		<button class="button button2">Discard</button>

	</div>

</body>

</html>