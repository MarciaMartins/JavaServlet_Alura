package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Dao.Bank;
import br.com.alura.gerenciador.model.Company;

@WebServlet("/excluirEmpresa")
public class excluirEmpresa extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Excluindo empresa");
		Bank bank = new Bank();
		
		String cnpjCompany = request.getParameter("cnpj");
		Company companyFind= bank.getCompanyByCnpj(cnpjCompany);
		if(companyFind!=null) bank.remove(companyFind.getId());
		response.sendRedirect("listarEmpresas");
		
	}

}
