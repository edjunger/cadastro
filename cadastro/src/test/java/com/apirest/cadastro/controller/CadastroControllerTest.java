package com.apirest.cadastro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.apirest.cadastro.controller.dto.TokenDto;
import com.apirest.cadastro.controller.form.LoginForm;
import com.apirest.cadastro.controller.form.PessoaForm;
import com.apirest.cadastro.document.Pessoa;
import com.apirest.cadastro.services.CadastroServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class CadastroControllerTest {
	
	@Autowired
	CadastroServices services;
	
	@Autowired
	AutenticacaoController auth;
	
	@Autowired
	MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;

	ResponseEntity<TokenDto> autenticar;
	
	Pessoa pessoa;
	
	PessoaForm pessoaForm;
	
	
	@BeforeEach
	void iniciar() {
		LoginForm login = new LoginForm();
		login.setCpf("777.777.777-77");
		login.setSenha("123456");
		autenticar = auth.autenticar(login);
		
		pessoa = new Pessoa("5f7238fe8d1a0a29b4d26845",
						    "Edmilson de Oliveira",
						    "M",
						    "ed.junger@gmail.com",
						    "12/09/2020",
						    "RJ",
						    "brazileiro",
						    "444.444.444-44",
						    "123456");
					
		pessoaForm = new PessoaForm("5f7238fe8d1a0a29b4d26845",
								    "Edmilson de Oliveira",
								    "M",
								    "ed.junger@gmail.com",
								    "12/09/2020",
								    "RJ",
								    "brazileiro",
								    "444.444.444-44");
									
	}	
	
	
	@Test
	void saveTest() throws Exception{
		mvc.perform(post("/pessoa/cadastrar")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoa)))
		        .andExpect(status().isOk());
	}
	
	
	@Test
	void consultaRegistrosTest() throws Exception{
		mvc.perform(get("/pessoa/listar")
				.header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .contentType("application/json"))
		        .andExpect(status().isOk());
	}
	

	@Test
	void consultarPorIdTest() throws Exception{
		
		PessoaForm pessoaForm = new PessoaForm();
		pessoaForm.setId("5f6d6377900c7803c28e6483");
		
		mvc.perform(get("/pessoa/id")
		        .contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}

	
	@Test
	void consultaPorNomeTest() throws Exception{
		mvc.perform(get("/pessoa/nome")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorSexoTest() throws Exception{
		mvc.perform(get("/pessoa/sexo")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorEmailTest() throws Exception{
		mvc.perform(get("/pessoa/email")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorDataTest() throws Exception{
		mvc.perform(get("/pessoa/data")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorNaturalidadeTest() throws Exception{
		mvc.perform(get("/pessoa/naturalidade")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorCpfTes() throws Exception{
		mvc.perform(get("/pessoa/cpf")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}
	
	@Test
	void consultaPorNacionalidadeTest() throws Exception{
		mvc.perform(get("/pessoa/nacionalidade")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoaForm)))
		        .andExpect(status().isOk());
	}

	
	@Test
	void atualizarTest() throws Exception{
		mvc.perform(post("/pessoa/atualizar")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoa)))
		        .andExpect(status().isOk());
	}

	@Test
	void removeTest() throws Exception{
		mvc.perform(post("/pessoa/remover")
				.contentType("application/json")
		        .header("Authorization", "Bearer "+autenticar.getBody().getToken())
		        .content(objectMapper.writeValueAsString(pessoa)))
		        .andExpect(status().isOk());
	}
	
	

}
