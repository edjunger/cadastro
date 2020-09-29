package com.apirest.cadastro.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.cadastro.controller.dto.PessoaDto;
import com.apirest.cadastro.document.Pessoa;
import com.apirest.cadastro.repository.CadastroRepository;

@Service
public class CadastroServicesImplement implements CadastroServices{
	
	@Autowired
	CadastroRepository repository;
	
	public List<PessoaDto> consultaRegistros(){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findAll()) {
			lista.add(PessoaDto.converter(pessoa));
		}
		
		return lista;
	}
	
	public PessoaDto consultarPorId(String id){	
		
		Optional<Pessoa> pessoa = repository.findById(id);
		if(pessoa.isPresent()) {
			return PessoaDto.converter(pessoa);
		}
		return null;
		
	}
	
	public List<PessoaDto> consultaPorNome(String nome){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByNome(nome)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		
		return lista;
	}
	
	public List<PessoaDto> consultaPorSexo(String sexo){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findBySexo(sexo)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		
		return lista;
	}
	
	public List<PessoaDto> consultaPorEmail(String email){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByEmail(email)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		
		return lista;
	}
	
	public List<PessoaDto> consultaPorData(String data){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByData(data)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		
		return lista;
	}
	
	public List<PessoaDto> consultaPorNaturalidade(String naturalidade){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByNaturalidade(naturalidade)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		return lista;
	}
	
	public List<PessoaDto> consultaPorCpf(String cpf){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByCpf(cpf)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		return lista;
	}
	
	public List<PessoaDto> consultaPorNacionalidade(String nacionalidade){
		List<PessoaDto> lista = new ArrayList<PessoaDto>();
		for (Pessoa pessoa : repository.findByNacionalidade(nacionalidade)) {
			lista.add(PessoaDto.converter(pessoa));
		}
		return lista;
	}

	public PessoaDto save(Pessoa pessoa){
		List<Pessoa> cpf = repository.findByCpf(pessoa.getCpf());
		if(cpf.isEmpty()) {
			pessoa.setDataDeCadastramento(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
			return PessoaDto.converter(repository.save(pessoa));
		}else {
			return null;
		}
	}

	@Transactional
	public void remove(Pessoa pessoa){
		Optional<Pessoa> id = repository.findById(pessoa.getId());
		if(id.isPresent()) { 
			repository.delete(id.get());
		}
		
	}
	
	
	public PessoaDto atualizar(Pessoa pessoa){
		Optional<Pessoa> p = repository.findById(pessoa.getId());
		
		if(p.isPresent()) {
			List<String> dataAtualizacao = p.get().getDataAtualizacao();
			dataAtualizacao.add(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
			pessoa.setDataAtualizacao(dataAtualizacao);		
			return PessoaDto.converter(repository.save(pessoa));
		}else {
			return null;
		}
	}
	

}
