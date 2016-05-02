package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;
import services.UsuarioService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login.equals("") || senha.equals("")){
			response.sendRedirect("login.jsp");
			return;
		}
		
		Usuario usuario = UsuarioService.efetuarLogin(login, senha);
		
		if(usuario == null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
		
		response.sendRedirect("index.jsp");
		
	}

}
