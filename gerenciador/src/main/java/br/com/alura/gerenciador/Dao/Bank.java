package br.com.alura.gerenciador.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.gerenciador.model.Company;

public class Bank {
	
	private static List<Company> listCompany = new ArrayList<>();
	private static Integer countCompany=0;
	
	private Integer idBusca=-1;
	
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
	
}
