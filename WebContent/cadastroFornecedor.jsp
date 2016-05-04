<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Fornecedor</title>
</head>
<body>
<%@ include file="menu.jsp"%>

	<br />
	<form method='post' action='CadastroFornecedor'>

		<input type='hidden' name='id' value="${fornecedor.id}" />
		
		<table>

			<tr>
				<td>Razão Social</td>
				<td><input type='text' name='nome' value="${fornecedor.nome}" /></td>
			</tr>
			
			<tr>
				<td>CNPJ</td>
				<td><input type='text' name='cnpj' value="${fornecedor.cnpj}" /></td>
			</tr>
			
			<tr>
				<td>Telefone</td>
				<td><input type='text' name='telefone' value="${fornecedor.telefone}" /></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type='text' name='email' value="${fornecedor.email}" /></td>
			</tr>

			<tr>
				<td><input type='submit' value='Salvar' /></td>
				
				<a href="login.jsp">Voltar</a>
			</tr>
			
			

		</table>

	</form>
	<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>
</html>