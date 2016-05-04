<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para funções -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Fornecedores</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	
	<br />
	<c:if test="${mensagem != null}">
		<script>
			alert('${mensagem}');
		</script>
	</c:if>
	<br />
	<br />
	
	
		<a href='CadastroFornecedor'>Novo</a>
	
	
	<br />
	<form method="get" action="ListarFornecedor">
		Razão Social:<input type="text" name="nomeFiltro" value="${param.nomeFiltro}" />
		CNPJ:<input type="text" name="cnpjFiltro" value="${param.cnpjFiltro}" />
		Telefone:<input type="text" name="telefoneFiltro" value="${param.telefoneFiltro}" />
		Email:<input type="text" name="emailFiltro" value="${param.emailFiltro}" />
		<input type="submit" value="pesquisar">
	</form>
	<br />
	<br />
	<br />
	<table>
		<tr>
			<td>Razão Social</td>
			<td>CNPJ</td>
			<td>Telefone Social</td>
			<td>Email</td>
			<td>Ações</td>
		</tr>
		<c:forEach var="fornecedor" items="${fornecedores}">
			<tr>
				<td>${fornecedor.nome}</td>
				<td>${fornecedor.cnpj}</td>
				<td>${fornecedor.telefone}</td>
				<td>${fornecedor.email}</td>
				<td><a href='RemoverFornecedor?id=${fornecedor.id}'>remover</a> <a
					href='CadastroFornecedor?id=${fornecedor.id}'>editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>

</html>