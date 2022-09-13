package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Dao.Bank;
import br.com.alura.gerenciador.model.Company;

@WebServlet("/editarEmpresa")
public class mostraEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Apresentando empresa para edição");
		
		Bank bank = new Bank();
		String cnpjCompany = request.getParameter("cnpj");
		Company companyFind = bank.getCompanyByCnpj(cnpjCompany);
		if(companyFind!=null) {
			request.setAttribute("company", companyFind);
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
			rd.forward(request, response);
		}
		
	}

	
}
