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
<title>Listagem de Unidades</title>
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
	
	
		<a href='CadastroUnidade'>Novo</a>
	
	
	<br />
	<form method="get" action="ListarUnidade">
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
		<c:forEach var="unidade" items="${unidades}">
			<tr>
				<td>${unidade.nome}</td>
				<td><a href='RemoverUnidade?id=${unidade.id}'>remover</a> <a
					href='CadastroUnidade?id=${unidade.id}'>editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>
</html>