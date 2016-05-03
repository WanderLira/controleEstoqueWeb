package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Categoria;
import entities.Produto;
import services.CategoriaService;
import services.ProdutoService;

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

		request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String idCat = request.getParameter("idCat");
		
		System.out.println(idCat);

		/*Produto produto = new Produto();

		produto.setNome(nome);

		if (id != null && !id.equals("")) {
			produto.setId(new Long(id));
			ProdutoService.atualizar(produto);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			ProdutoService.inserir(produto);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarProdutoServlet").forward(request, response);*/

	}

}
