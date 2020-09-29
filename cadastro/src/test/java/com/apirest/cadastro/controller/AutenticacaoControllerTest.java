package com.apirest.cadastro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.apirest.cadastro.controller.form.LoginForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AutenticacaoControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void autenticar() throws JsonProcessingException, Exception {
		
		LoginForm login = new LoginForm();
		login.setCpf("443.333.333-33");
		login.setSenha("123456");
		
		mvc.perform(post("/auth")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(login)))
		        .andExpect(status().isOk());
		
		
		
	}
}
