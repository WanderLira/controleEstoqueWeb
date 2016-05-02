package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Unidade;
import services.UnidadeService;

public class CadastroUnidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.jsp");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Unidade unidade = UnidadeService.buscarPorId(new Long(id));
			request.setAttribute("unidade", unidade);
		}

		request.getRequestDispatcher("cadastroUnidade.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		
		Unidade unidade = new Unidade();

		unidade.setNome(nome);
		

		if (id != null && !id.equals("")) {
			unidade.setId(new Long(id));
			UnidadeService.atualizar(unidade);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			UnidadeService.inserir(unidade);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarUnidade").forward(request, response);

	}

}
