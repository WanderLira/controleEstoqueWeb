<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para fun��es -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de card�pios</title>
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
	<br />
	<a href='CadastroProduto'>Novo</a>

	<form method="get" action="ListarProduto">
		Nome:<input type="text" name="nomeFiltro" value="${param.nomeFiltro}" />
		Preco:<input type="text" name="precoVendaFiltro" value="${param.precoVendaFiltro}" /> 
		Quantidade:<input type="text" name="qtdeEstoqueFiltro" value="${param.qtdeEstoqueFiltro}" /> 
		Categoria:<input type="text" name="categoriaFiltro" value="${param.categoriaFiltro}" />
		Unidade:<input type="text" name="unidadeFiltro" value="${param.unidadeFiltro}" /> 
		Fornecedor:<input type="text" name="fornecedorFiltro" value="${param.fornecedorFiltro}" /> 
			<input type="submit" value="pesquisar" />
	</form>

	<br />
	<br />
	<br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Pre�o</td>
			<td>Estoque</td>
			<td>Categoria</td>
			<td>Unidade</td>
			<td>Fornecedor</td>
			<td>A��es</td>
		</tr>

		<c:forEach var="produto" items="${produtos}">

			<tr>
				<td>${produto.nome}</td>
				<td><fmt:formatNumber type="currency" value="${produto.precoVenda}" /></td>
				<td>${produto.qtdeEstoque}</td>
				<td>${produto.categoria.nome}</td>
				<td>${produto.unidade.nome}</td>
				<td>${produto.fornecedor.nome}</td>
				<td><a href='RemoverProduto?id=${produto.id}'>remover</a> <a
					href='CadastroProduto?id=${produto.id}'>editar</a></td>
			</tr>
		</c:forEach>

	</table>

	<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>
</html>