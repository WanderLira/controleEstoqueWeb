<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de cardápios</title>
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
		    
		    Nome:<input type="text" name="nomeFiltro" value="${param.nomeFiltro}"/>
		    Preco:<input type="text" name="precoFiltro" value="${param.precoFiltro}"/>
		    Quantidade:<input type="text" name="precoFiltro" value="${param.qtdeEstoque}"/>
		    Categoria:<input type="text" name="precoFiltro" value="${param.categoria}"/>
		    Unidade:<input type="text" name="precoFiltro" value="${param.unidade}"/>			    
		    <input type="submit" value="pesquisar">
		    </form>
		    
		    <br />
		    <br />
		    <br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Preço</td>
			<td>Ações</td>
		</tr>
		
		<c:forEach var="produto" items="${produtos}" >
			
		<tr>
			<td>${produto.nome}</td>
			<td><fmt:formatNumber type="currency" value="${produto.precoVenda}"/></td>
			<td>${produto.qtdeEstoque}</td>
			<td>${produto.categoria}</td>
			<td>${produto.unidade}</td>
			<td>
				<a href='removerProduto?id=${produto.id}'>remover</a>
				<a href='cadastroProduto?id=${produto.id}'>editar</a>
			</td>
		</tr>
		</c:forEach>

	</table>

<br />
	<br />
	<br />
	<%@ include file="rodape.jsp"%>
</body>
</html>