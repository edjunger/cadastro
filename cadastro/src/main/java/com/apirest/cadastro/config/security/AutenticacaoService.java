package com.apirest.cadastro.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apirest.cadastro.document.Pessoa;
import com.apirest.cadastro.repository.CadastroRepository;



@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private CadastroRepository repository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

		Pessoa usuario = repository.findByCpf(cpf).get(0);
		if (usuario != null) {
			return usuario;
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
