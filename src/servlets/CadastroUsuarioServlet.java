package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.Usuario;
import services.UsuarioService;

public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect("login.jsp");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Usuario usuario = UsuarioService.buscarPorId(new Long(id));
			request.setAttribute("usuario", usuario);
		}

		request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");

		Usuario usuario = new Usuario();

		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setMatricula(matricula);
		usuario.setNome(nome);
		

		if (id != null && !id.equals("")) {
			usuario.setId(new Long(id));
			UsuarioService.atualizar(usuario);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			UsuarioService.inserir(usuario);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("Login").forward(request, response);

	}

}
