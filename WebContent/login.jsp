<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de login</title>
</head>
<body>

	<fieldset>
		<form method="post" action="Login">

			Login<input type="text" name="login" /> Senha<input type="password"
				name="senha" /> <input type="submit" value="logar">

		</form>

		<div class="checkbox">
			<label> <input name="remember" type="checkbox"
				value="Remember Me">Lembrar-me
			</label>
		</div>
		<a href="CadastroUsuario" class="btn btn-lg btn-success btn-block">Novo
			Usuario</a>
	</fieldset>
</body>
</html>