package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Fornecedor;
import services.FornecedorService;

public class RemoverFornecedorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FornecedorService.remover(new Fornecedor(new Long(id)));
		response.sendRedirect("ListarFornecedor");
	}

	
}
