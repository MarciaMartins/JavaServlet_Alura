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
				
		//criando uma classe para simular o banco e recuperando por Id criado
		Bank bank = new Bank();
		Integer positionBank = bank.add(company);
		company = bank.getCompanyById(positionBank);
				
		CompanyResponse responseCompany = new CompanyResponse(company);
				
		System.out.println("Cadastrando nova empresa");
		PrintWriter out = response.getWriter();
		out.println("<html><body> <p>Empresa <i><b>"
				+ responseCompany.getName() +"</i></b> cadastrada com sucesso.</p>"
						+ "<p>CNPJ - "+ responseCompany.getCnpj()
				+ "</p></body></html>");
	}

}
