package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Unidade;
import services.UnidadeService;

public class RemoverUnidadeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UnidadeService.remover(new Unidade(new Long(id)));
		response.sendRedirect("ListarUnidade");
	}

	
}