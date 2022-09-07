package br.com.alura.gerenciador.model.dto;

import br.com.alura.gerenciador.model.Company;

public class CompanyResponse {
	
	private String name;
	private String cnpj;
	
	public CompanyResponse(Company company) {
		this.name=company.getName();
		this.cnpj=company.getCnpjMask();
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getName() {
		return name;
	}
	
}
