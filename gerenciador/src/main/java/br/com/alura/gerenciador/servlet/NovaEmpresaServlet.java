package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameCompany = request.getParameter("name");
		String cpfCompany = request.getParameter("cpf");
		
		System.out.println("Cadastrando nova empresa");
		PrintWriter out = response.getWriter();
		out.println("<html><body> <p>Empresa <i><b>"
				+ nameCompany +"</i></b> cadastrada com sucesso.</p>"
						+ "<p>CPF - "+ cpfCompany 
				+ "</p></body></html>");
	}

}
