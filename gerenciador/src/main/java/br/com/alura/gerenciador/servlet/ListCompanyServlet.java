package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Dao.Bank;
import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.dto.CompanyResponse;

@WebServlet("/listarEmpresas")
public class ListCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		List<Company> listCompany = bank.getListCompany();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body> <p>Empresas cadastradas no sistema</p>"
				+ "<ul>");
		
		listCompany.forEach(c-> {
			CompanyResponse responseCompany = new CompanyResponse(c);
			out.println("<li><i><b>"
					+ responseCompany.getName() 
					+"</i></b>. CNPJ - "+ responseCompany.getCnpj()+"</li>");
		});
		out.println("<ul></html></body>");
	}

}
