package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.FornecedorService;
import entities.Fornecedor;

public class ListarFornecedorServlet extends HttpServlet {
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
		String filtroCnpj = request.getParameter("cnpjFiltro");
		String filtroTelefone = request.getParameter("telefoneFiltro");
		String filtroEmail = request.getParameter("emailFiltro");
		Fornecedor filtro = new Fornecedor();
		filtro.setNome(filtroNome);
		filtro.setCnpj(filtroCnpj);
		filtro.setTelefone(filtroTelefone);
		filtro.setEmail(filtroEmail);

		List<Fornecedor> fornecedores = FornecedorService.buscar(filtro);
		request.setAttribute("fornecedores", fornecedores);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarFornecedores.jsp");
		requestDispatcher.forward(request, response);

	}

}
