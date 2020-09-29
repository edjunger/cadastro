package com.apirest.cadastro.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String cpf;
	private String senha;

	
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


	public UsernamePasswordAuthenticationToken converter() {
		/*return new UsernamePasswordAuthenticationToken("333.333.333-33", "$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");*/
		return new UsernamePasswordAuthenticationToken(cpf, senha);
	}

}
