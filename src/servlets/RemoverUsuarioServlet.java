package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Usuario;
import services.UsuarioService;

public class RemoverUsuarioServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UsuarioService.remover(new Usuario(new Long(id)));
		response.sendRedirect("ListarUsuario");
	}

	
}
