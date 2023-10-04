<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crud Psicologo</title>
<link rel="stylesheet" href="styles/stylecrud.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>
	<div class="card">
		<div class="menu">
			<div class="toggle">
				<div class="line-1"></div>
				<div class="line-2"></div>
			</div>
			<ul>
				<li>
					<form action="psychologistcontrollerservlet" method="get">
						<div id="createButton" class="create-button">
							<i class="fas fa-plus-circle fa-lg"></i>
							 <input name="operation" type="hidden" value="create" /> 
							 <input type="submit" value="create">
						</div>
					</form>
				</li>
				<li>
					<form action="psychologistcontrollerservlet" method="get">
						<div id="createButton" class="create-button">
							<i class="fas fa-book fa-lg"></i> <input name="operation"
								type="hidden" value="read" /> <input type="submit" value="read">
						</div>
					</form>
				</li>
				<li>
					<form action="psychologistcontrollerservlet" method="get">
						<div id="createButton" class="create-button">
						<i class="fas fa-edit fa-lg"></i>
							<input name="operation" type="hidden" value="update" /> <input
								type="submit" value="Update">
						</div>
					</form>
				</li>
				<li>
					<form action="psychologistcontrollerservlet" method="get">
						<div id="createButton" class="create-button">
						<i class="fas fa-solid fa-trash fa-lg"></i>
							<input name="operation" type="hidden" value="delete" /> <input
								type="submit" value="Delete">
						</div>
					</form>
				</li>
				<li>
				<i class="fas fa-cog fa-lg"></i> <span>Settings</span></li>

			</ul>
		</div>
	</div>
	<script>
		let menu = document.querySelector('.menu');
		let toggle = document.querySelector('.toggle');


		toggle.addEventListener('click', () => {
			menu.classList.toggle('active');
		});

	</script>
</body>
</html>