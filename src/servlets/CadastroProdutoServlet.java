package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Produto;
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

		request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");

		Produto produto = new Produto();

		produto.setNome(nome);

		if (id != null && !id.equals("")) {
			produto.setId(new Long(id));
			ProdutoService.atualizar(produto);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			ProdutoService.inserir(produto);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarProdutoServlet").forward(request, response);

	}

}
