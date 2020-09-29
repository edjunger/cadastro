package com.apirest.cadastro.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.cadastro.controller.dto.PessoaDto;
import com.apirest.cadastro.controller.form.PessoaForm;
import com.apirest.cadastro.document.Pessoa;
import com.apirest.cadastro.services.CadastroServices;

@RestController
@RequestMapping("/pessoa")
public class CadastroController {
	@Autowired(required=true)
	CadastroServices services;
	
	@GetMapping(value="/listar")
	public List<PessoaDto> consultaRegistros(){
		return services.consultaRegistros();
	}
	
	@GetMapping(value="/{id}")
	public PessoaDto consultarPorId(@PathVariable String id){
		return services.consultarPorId(id);
	}
	
	@GetMapping(value="/nome")
	public List<PessoaDto> consultaPorNome(@RequestBody PessoaForm form){
		return services.consultaPorNome(form.getNome());
	}
	
	@GetMapping(value="/sexo")
	public List<PessoaDto> consultaPorSexo(@RequestBody PessoaForm form){
		return services.consultaPorSexo(form.getSexo());
	}
	
	@GetMapping(value="/email")
	public List<PessoaDto> consultaPorEmail(@RequestBody PessoaForm form){
		return services.consultaPorEmail(form.getEmail());
	}
	
	@GetMapping(value="/data")
	public List<PessoaDto> consultaPorData(@RequestBody PessoaForm form){
		return services.consultaPorData(form.getData());
	}
	
	@GetMapping(value="/naturalidade")
	public List<PessoaDto> consultaPorNaturalidade(@RequestBody PessoaForm form){
		return services.consultaPorNaturalidade(form.getNaturalidade());
	}
	
	@GetMapping(value="/cpf")
	public List<PessoaDto> consultaPorCpf(@RequestBody PessoaForm form){
		return services.consultaPorCpf(form.getCpf());
	}
	
	@GetMapping(value="/nacionalidade")
	public List<PessoaDto> consultaPorNacionalidade(@RequestBody PessoaForm form){
		return services.consultaPorNacionalidade(form.getNacionalidade());
	}
	
	@PostMapping(value="/cadastrar")
	public PessoaDto save(@RequestBody Pessoa pessoa){
		org.springframework.security.crypto.password.PasswordEncoder encoder
		   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		System.out.println(pessoa.getSenha());
		
		return services.save(pessoa);
	}
	
	@PostMapping(value="/conta")
	public PessoaDto saveLogin(@RequestBody Pessoa pessoa){
		org.springframework.security.crypto.password.PasswordEncoder encoder
		   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		System.out.println(pessoa.getSenha());
		
		return services.save(pessoa);
	}
	
	@PostMapping(value="/remover")
	public void remove(@RequestBody Pessoa pessoa){
		services.remove(pessoa);
	}
	
	@PostMapping(value="/atualizar")
	public PessoaDto atualizar(@RequestBody Pessoa pessoa){
		return services.atualizar(pessoa);
	}
	
	
}
