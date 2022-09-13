package br.com.alura.gerenciador.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return listCompany.get(companyId);
	}
	
	public Boolean remove(Integer companyId) {
		if(listCompany.size()>=companyId) {
			listCompany.removeIf(company -> company.getId().equals(companyId));
			return true;	
		}
		return false; 
	}
	
	public Company getCompanyByCnpj(String cnpj) {
		List<Company> listCompanyFind = listCompany.stream()
			.filter(c -> c.getCnpj().contains(cnpj))
			.collect(Collectors.toList());
		if(listCompanyFind.isEmpty()) return null;
		return listCompanyFind.get(0);
	}
	
	public Company updateCompany(Company company, String name, LocalDate date){
		Company updateCompany = listCompany.get(company.getId());
		
		if(company.getName().contains(name) == false) {
			System.out.println("novo nome");
			updateCompany.setName(name);
		}
		if(company.getDate().equals(date) == false) {
			System.out.println("novo data");
			updateCompany.setDate(date);
		}
		
		
		return updateCompany;
	}
	
}
