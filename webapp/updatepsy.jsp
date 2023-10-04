<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar</title>
	<link rel="stylesheet" href="styles/stylecrud.css">
	<script src="js/script.js"></script>
</head>

<body>
	<h1>Selecciona el rol a actualizar</h1>
	<select id="rol" onchange="mostrarCuadros()">
		<option value="ninguno">Selecciona un rol</option>
		<option value="visitante">Visitante</option>
		<option value="serviciosgenerales">Servicios Generales</option>
	</select>
	<br>
	<br>
	<br>

	<div id="createButton" class="create-button">
	 <div class="cuadro" id="visitante" style="display: none">
        <label for="cedula">Cedula:</label>
        <input type="text" id="cedula" name="cedula" maxlength="10">
        <button class="button button1" onclick="window.location.href='Updatevis.html'">Next</button>
        <button class="button button2">Discard</button>
    </div>
</div>

	<div id="createButton" class="create-button">
	 <div class="cuadro" id="serviciosgenerales" style="display: none">
        <label for="cedula">Cedula:</label>
        <input type="text" id="cedula" name="cedula" maxlength="10">
        <button class="button button1" onclick="window.location.href='UpdateSerGen.html'">Next</button>
        <button class="button button2">Discard</button>
    </div>
</div>



</body>

</html>