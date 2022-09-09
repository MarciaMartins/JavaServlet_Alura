package br.com.alura.gerenciador.Dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Company;

public class Bank {
	
	private static List<Company> listCompany = new ArrayList<>();
	private static Integer countCompany=0;
	
	static {
		Company Alura = new Company("Alura", "123444");
		Company Caelum = new Company("Caelum", "33444");
		listCompany.add(Alura);
		listCompany.add(Caelum);
	}

	public Integer add(Company company) {
		company.setId(countCompany++); 
		listCompany.add(company);
		return company.getId();
	}
	
	public List<Company> getListCompany(){
		return Bank.listCompany;
	}
	
	public Company getCompanyById(Integer companyId) {
		return listCompany.get(companyId);
	}

}
