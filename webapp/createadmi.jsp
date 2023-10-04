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
		<option value="serviciosgenerales">Servicios Generales</option>
		<option value="psicologo">Psicologo</option>
		
	</select>
	<br>
	<br>
	<br>

	<div class="cuadro" id="visitante" style="display: none">
	<form action="admicontrollerservlet" method="post">
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
		<input name="operation" type="hidden" value="read" /> <input type="submit" value="Read">
		<input type="submit" id="cre">
		<button class="button button1">Save</button>
		<button class="button button2">Discard</button>
	</div>


	<div class="cuadro" id="serviciosgenerales" style="display: none">
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
	
	<div class="cuadro" id="psicologo" style="display: none">
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
		<label for="añograd">Año de graduacion:</label>
		<input type="text" id="añograd" name="añograd">
		<br>
		<br>
		<label for="diasser">Dias de servicio:</label>
		<input type="text" id="diasser" name="diasser">
		<br>
		<br>
		<label for="sesionap">Sesiones apoyadas:</label>
		<input type="text" id="sesionap" name="sesionap">
		<br>
		<br>
		<label for="salariop">Salario:</label>
		<input type="text" id="salariop" name="salariop">
		<br>
		<br>
		<button class="button button1">Save</button>
		<button class="button button2">Discard</button>

	</div>

</body>

</html>