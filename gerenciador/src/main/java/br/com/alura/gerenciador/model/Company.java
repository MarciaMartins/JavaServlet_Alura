package br.com.alura.gerenciador.model;

import java.time.LocalDate;

public class Company {
	
	private Integer id;
	private String name;
	private String cnpj;
	private LocalDate date;
	
	public Company(String name, String cnpj) {
		this.name=name;
		this.cnpj=cnpj;
		this.date = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCnpjMask() {
		return this.cnpj.replaceAll("(\\d{2})(\\d{2})", "$2.$1");
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}

}
