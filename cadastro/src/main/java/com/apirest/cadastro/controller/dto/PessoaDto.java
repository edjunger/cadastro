package com.apirest.cadastro.controller.dto;

import java.util.List;
import java.util.Optional;

import com.apirest.cadastro.document.Pessoa;

public class PessoaDto {
	
	private String id;
	private String nome;
	private String sexo;
	private String email;
	private String data;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private String dataDeCadastramento;
	private List<String> dataAtualizacao;  
	
	
	public PessoaDto(String id, String nome, String sexo, String email, String data, String naturalidade,
			String nacionalidade, String cpf, String dataDeCadastramento, List<String> dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.data = data;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		this.dataDeCadastramento = dataDeCadastramento;
		this.dataAtualizacao = dataAtualizacao;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataDeCadastramento() {
		return dataDeCadastramento;
	}


	public void setDataDeCadastramento(String dataDeCadastramento) {
		this.dataDeCadastramento = dataDeCadastramento;
	}


	public List<String> getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(List<String> dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public static PessoaDto converter(Pessoa pessoa) {
		return new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getSexo(), pessoa.getEmail(),pessoa.getData(), pessoa.getNaturalidade(), pessoa.getNacionalidade(), pessoa.getCpf(), pessoa.getDataDeCadastramento(), pessoa.getDataAtualizacao());
	}

	public static PessoaDto converter(Optional<Pessoa> pessoa) {
		return new PessoaDto(pessoa.get().getId(), pessoa.get().getNome(), pessoa.get().getSexo(), pessoa.get().getEmail(),pessoa.get().getData(), pessoa.get().getNaturalidade(), pessoa.get().getNacionalidade(), pessoa.get().getCpf(), pessoa.get().getDataDeCadastramento(), pessoa.get().getDataAtualizacao());
	}


}
