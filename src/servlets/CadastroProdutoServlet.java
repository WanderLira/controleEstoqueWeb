package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Categoria;
import entities.Fornecedor;
import entities.Produto;
import entities.Unidade;
import services.CategoriaService;
import services.FornecedorService;
import services.ProdutoService;
import services.UnidadeService;

public class CadastroProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Produto produto = ProdutoService.buscarPorId(new Long(id));
			request.setAttribute("produto", produto);
		}
		List<Categoria> categorias = CategoriaService.listar();
		request.setAttribute("categorias", categorias);

		List<Unidade> unidades = UnidadeService.listar();
		request.setAttribute("unidades", unidades);
		
		List<Fornecedor> fornecedores = FornecedorService.listar();
		request.setAttribute("fornecedores", fornecedores);

		request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String precoVenda = request.getParameter("precoVenda");
		String qtdeEstoque = request.getParameter("qtdeEstoque");
		String idCat = request.getParameter("idCat");
		String idUni = request.getParameter("idUni");
		String idFor = request.getParameter("idFor");
	

		Produto produto = new Produto();

		produto.setNome(nome);
		produto.setPrecoVenda(new Double(precoVenda));
		produto.setQtdeEstoque(new Integer (qtdeEstoque));
		produto.setCategoria(CategoriaService.buscarPorId(new Long(idCat)));
		produto.setUnidade(UnidadeService.buscarPorId(new Long(idUni)));
		produto.setFornecedor(FornecedorService.buscarPorId(new Long(idFor)));
		

		if (id != null && !id.equals("")) {
			produto.setId(new Long(id));
			ProdutoService.atualizar(produto);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			ProdutoService.inserir(produto);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarProduto").forward(request, response);

	}

}
