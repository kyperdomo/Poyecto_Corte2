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
	<form action="admicontrollerservlet" method="post">
		<div class="login_form_container">
			<div class="login_form">
				<h2>LoginAd</h2>
				<div class="input_group">
					<i class="fa fa_user"></i> <input type="text"
						placeholder="Username" class="input_text" autocomplete="off" />
				</div>
				<div class="input_group">
					<i class="fa fa-unclock-alt"></i> <input type="password"
						placeholder="Password" class="input_text" autocomplete="off" />
				</div>

				<input class="input_text" type="submit" value="login">

			</div>
		</div>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="script.js"></script>

	</form>
</body>

</html>