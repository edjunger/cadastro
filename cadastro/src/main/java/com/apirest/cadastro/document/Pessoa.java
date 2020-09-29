package com.apirest.cadastro.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Document 
public class Pessoa implements UserDetails { 
	
	
	private static final long serialVersionUID = 4784951884830988325L;
	@Id
	private String id;
	private String nome;
	private String sexo;
	private String email;
	private String data;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private String senha;
	private String dataDeCadastramento;
	private List<String> dataAtualizacao = new ArrayList<>();  
	private List<Perfil> perfis = new ArrayList<>();
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String sexo, String email, String data, String naturalidade,
			String nacionalidade, String cpf) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.data = data;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		
	}


	public Pessoa(String id, String nome, String sexo, String email, String data, String naturalidade,
			String nacionalidade, String cpf, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.data = data;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		this.senha = senha;
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.perfis;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
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
	
	


	
	
}
