package com.apirest.cadastro.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.cadastro.document.Pessoa;

@Repository
public interface CadastroRepository extends MongoRepository<Pessoa, String>{

	List<Pessoa> findByNome(String nome);

	List<Pessoa> findBySexo(String sexo);

	List<Pessoa> findByEmail(String email);

	List<Pessoa> findByData(String data);

	List<Pessoa> findByNaturalidade(String naturalidade);

	List<Pessoa> findByCpf(String cpf);

	List<Pessoa> findByNacionalidade(String nacionalidade);


}
