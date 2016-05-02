package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Categoria;
import services.CategoriaService;

public class RemoverProdutoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CategoriaService.remover(new Categoria(new Long(id)));
		response.sendRedirect("ListarProdutoServlet");
	}

	
}
