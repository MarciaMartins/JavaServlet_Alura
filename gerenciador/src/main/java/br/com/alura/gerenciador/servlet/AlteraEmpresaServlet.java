package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Dao.Bank;
import br.com.alura.gerenciador.model.Company;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/armazenaEmpresaAlterada")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Armazenando alterações empresa");
		
		String name = request.getParameter("name");
		System.out.println(name);
		String dateString = request.getParameter("date");
		LocalDate date = LocalDate.parse(dateString);
		System.out.println(date);
		String cnpj = request.getParameter("cnpj");
		System.out.println(cnpj);
		
		Bank bank = new Bank();
		Company company = bank.getCompanyByCnpj(cnpj);
		if(company!=null) {
			company = bank.updateCompany(company, name, date);
			request.setAttribute("company", company);
			response.sendRedirect("listarEmpresas");
			
		}
		
		
		
		
	}

}
