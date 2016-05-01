package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.CategoriaService;
import entities.Categoria;

public class ListarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String filtroNome = request.getParameter("nomeFiltro");
		Categoria filtro = new Categoria();
		filtro.setNome(filtroNome);

		List<Categoria> categorias = CategoriaService.buscar(filtro);
		request.setAttribute("categorias", categorias);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCategorias.jsp");
		requestDispatcher.forward(request, response);

	}

}
