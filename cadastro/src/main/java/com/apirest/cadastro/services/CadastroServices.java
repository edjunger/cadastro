package com.apirest.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.cadastro.controller.dto.PessoaDto;
import com.apirest.cadastro.document.Pessoa;

@Service
public interface CadastroServices {

	public List<PessoaDto> consultaRegistros();

	public PessoaDto consultarPorId(String id);
	
	public List<PessoaDto> consultaPorNome(String nome);
	
	public List<PessoaDto> consultaPorSexo(String sexo);
	
	public List<PessoaDto> consultaPorEmail(String email);
	
	public List<PessoaDto> consultaPorData(String data);
	
	public List<PessoaDto> consultaPorNaturalidade(String naturalidade);
	
	public List<PessoaDto> consultaPorCpf(String cpf);
	
	public List<PessoaDto> consultaPorNacionalidade(String nacionalidade);
	
	public PessoaDto save(Pessoa pessoa);	

	public void remove(Pessoa pessoa);
	
	public PessoaDto atualizar(Pessoa pessoa);
	

}
