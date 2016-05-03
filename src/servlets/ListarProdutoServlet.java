package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.Produto;
import services.ProdutoService;

public class ListarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String filtroNome = request.getParameter("nomeFiltro");
		
		Produto filtro = new Produto();
		filtro.setNome(filtroNome);

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		List<Produto> produtos = ProdutoService.listar();
		request.setAttribute("produtos", produtos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProdutos.jsp");
		requestDispatcher.forward(request, response);
	}
}
