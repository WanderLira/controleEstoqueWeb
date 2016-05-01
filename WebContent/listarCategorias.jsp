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
<title>Listagem de Categorias</title>
</head>
<body>
	<a href='CadastroCategoria'>Novo</a>
	<br />
	<c:if test="${mensagem != null}">
		<script>
			alert('${mensagem}');
		</script>
	</c:if>
	<br />
	<br />
	
	
		<li><a href="Logout">Logout</a></li>
	
	
	<br />
	<form method="get" action="ListarCategoria">
		Nome:<input type="text" name="nomeFiltro" value="${param.nomeFiltro}" />
		<input type="submit" value="pesquisar">
	</form>
	<br />
	<br />
	<br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Ações</td>
		</tr>
		<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.nome}</td>
				<td><a href='RemoverCategoria?id=${categoria.id}'>remover</a> <a
					href='CadastroCategoria?id=${categoria.id}'>editar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>