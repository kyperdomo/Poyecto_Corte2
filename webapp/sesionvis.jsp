<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="styles/stylesesion.css" />
</head>
<body>
	<form action="alcoholiccontrollerservlet" method="post">

		<div class="login_form_container">
			<div class="login_form">
				<h2>LoginV</h2>
				<div class="input_group">
					<i class="fa fa_user"></i> 
					
					<input name="username" type="text" placeholder="Name" id="username" class="input_text">
				</div>
				<div class="input_group">
					<i class="fa fa-unclock-alt"></i> <input name="password"
						type="password" placeholder="ID number" id="password"
						class="input_text">
				</div>
				<input class="input_text" type="submit"
					value="login">

			</div>
		</div>
	</form>

</body>
</html>