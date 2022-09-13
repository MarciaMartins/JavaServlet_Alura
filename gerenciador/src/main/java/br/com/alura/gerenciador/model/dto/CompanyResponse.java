package br.com.alura.gerenciador.model.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.com.alura.gerenciador.model.Company;

public class CompanyResponse {

	private String name;
	private String cnpj;
	private Date date;
	
	public CompanyResponse(Company company) {
		this.name=company.getName();
		this.cnpj=company.getCnpj();
		this.date= convertDate(company.getDate());
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getName() {
		return name;
	}
	
	public Date convertDate(LocalDate dateLocal) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		return Date.from(dateLocal.atStartOfDay(defaultZoneId).toInstant());
	}
	
	public Date getDate() {
		return date;
	}
	
	
}
