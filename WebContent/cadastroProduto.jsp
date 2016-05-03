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
<title>Cadastro de Produto</title>
</head>
<body>


	<%@ include file="menu.jsp"%>

	<br />
	<br />
	<br />
	<br />
	<form method='post' action='CadastroProduto'>

		<input type='hidden' name='id' value="${produto.id}" />
		<table>

			<tr>
				<td>Nome</td>
				<td><input type='text' name='nome' value="${produto.nome}" /></td>
			</tr>

			<tr>
				<td>Preço</td>
				<td><input type='text' name='precoVenda'
					value="${produto.precoVenda}" /></td>
			</tr>
			<tr>
				<td>Quantidade</td>
				<td><input type='text' name='qtdeEstoque'
					value="${produto.qtdeEstoque}" /></td>
			</tr>
			<tr>
				<td>Categoria</td>
				<td><input type='text' name='categoria'
					value="${categoria.listar}" /></td>
			</tr>

			<tr>
				<td>Unidade</td>
				<td><input type='text' name='unidade'
					value="${unidade.listar}" /></td>
			</tr>


			<select>
				<optgroup label="Categoria">
					<option value="volvo">${categoria.listar}</option>

				</optgroup>

			</select>
			<select name="idCat">
				<optgroup label="Unidade">
				<option>-- categorias -- </option>
					<c:forEach var="cat" items="${categorias}">
					<option value="${cat.id}">${cat.nome}</option>
					</c:forEach>
					

				</optgroup>
			</select>


			<tr>
				<td><input type='submit' value='Salvar' /></td>
				<td></td>
			</tr>

		</table>

	</form>
	<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>
</html>