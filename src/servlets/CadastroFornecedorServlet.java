package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.Fornecedor;
import services.FornecedorService;

public class CadastroFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect("login.jsp");
		}
		String id = request.getParameter("id");

		if (id != null) {
			Fornecedor fornecedor = FornecedorService.buscarPorId(new Long(id));
			request.setAttribute("fornecedor", fornecedor);
		}

		request.getRequestDispatcher("cadastroFornecedor.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setTelefone(telefone);
		fornecedor.setEmail(email);	

		if (id != null && !id.equals("")) {
			fornecedor.setId(new Long(id));
			FornecedorService.atualizar(fornecedor);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		} else {
			FornecedorService.inserir(fornecedor);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}

		request.getRequestDispatcher("ListarFornecedor").forward(request, response);

	}

}
