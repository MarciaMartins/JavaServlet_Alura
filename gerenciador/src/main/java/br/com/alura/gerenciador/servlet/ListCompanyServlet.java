package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Dao.Bank;
import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.dto.CompanyResponse;

@WebServlet("/listarEmpresas")
public class ListCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<CompanyResponse> listCompanyResponse = new ArrayList<CompanyResponse>();
	private Boolean firstCall = true;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		
		
		List<Company> listCompany = bank.getListCompany();
		if(listCompany.isEmpty() && firstCall) {
			Company Alura = new Company("Alura", "123444");
			Company Caelum = new Company("Caelum", "33444");
			bank.add(Alura);
			bank.add(Caelum);
			firstCall=false;
		}		
		
		listCompany.forEach(c -> {
			CompanyResponse compResp = new CompanyResponse(c);
			listCompanyResponse.add(compResp);
		});
		
		System.out.println("Listando empresas");
		request.setAttribute("listCompany", listCompanyResponse );
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
