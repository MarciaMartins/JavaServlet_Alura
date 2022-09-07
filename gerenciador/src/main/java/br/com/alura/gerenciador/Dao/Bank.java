package br.com.alura.gerenciador.Dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Company;

public class Bank {
	
	private static List<Company> listCompany = new ArrayList<>();
	private static Integer countCompany=0;

	public Integer add(Company company) {
		company.setId(countCompany++); 
		listCompany.add(company);
		return company.getId();
	}
	
	public List<Company> getListCompany(){
		return Bank.listCompany;
	}
	
	public Company getCompanyById(Integer companyId) {
		System.out.println("Bnaco");
		return listCompany.get(companyId);
	}

}
