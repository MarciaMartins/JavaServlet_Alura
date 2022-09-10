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
import br.com.alura.gerenciador.model.dto.CompanyRequest;
import br.com.alura.gerenciador.model.dto.CompanyResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameCompany = request.getParameter("name");
		String cnpjCompany = request.getParameter("cnpj");
				
		CompanyRequest requestCompany = new CompanyRequest(nameCompany, cnpjCompany);
		Company company = requestCompany.convertToObject();
				
		Bank bank = new Bank();
		Integer positionBank = bank.add(company);
		company = bank.getCompanyById(positionBank);
		
		CompanyResponse responseCompany = new CompanyResponse(company);
		System.out.println("Cadastrando nova empresa");
		request.setAttribute("company", responseCompany.getName());
		request.setAttribute("cnpj", responseCompany.getCnpj());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		requestDispatcher.forward(request, response);
	
	}

}
