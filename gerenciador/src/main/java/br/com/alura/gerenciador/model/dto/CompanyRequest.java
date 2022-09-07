package br.com.alura.gerenciador.model.dto;

import br.com.alura.gerenciador.model.Company;

public class CompanyRequest {
	
	private String name;
	private String cnpj;
	
	public CompanyRequest(String name, String cnpj) {
		this.name = name;
		this.cnpj = cnpj;
	}
	
	public Company convertToObject() {
		return new Company(this.name, this.cnpj);
	}
	
	public String getCnpj() {
		return cnpj;
	}
	

}
