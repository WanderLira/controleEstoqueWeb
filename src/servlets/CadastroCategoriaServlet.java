package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Categoria;
import services.CategoriaService;

public class CadastroCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.jsp");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Categoria categoria = CategoriaService.buscarPorId(new Long(id));
			request.setAttribute("categoria", categoria);
		}

		request.getRequestDispatcher("cadastroCategoria.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		
		Categoria categoria = new Categoria();

		categoria.setNome(nome);
		

		if (id != null && !id.equals("")) {
			categoria.setId(new Long(id));
			CategoriaService.atualizar(categoria);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			CategoriaService.inserir(categoria);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarCategoria").forward(request, response);

	}

}
