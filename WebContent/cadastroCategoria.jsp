<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Categoria</title>
</head>
<body>
     
 
	<br />
	<form method='post' action='CadastroCategoria'>
	
	    <input type='hidden' name='id' value="${categoria.id}" />
		<table>
			
			<tr>
				<td>Nome</td>
				<td><input type='text' name='nome' value="${categoria.nome}" /></td>
			</tr>

			<tr>
				<td><input type='submit' value='Salvar' /></td>
				<td></td>
			</tr>

		</table>

	</form>
</body>
</html>