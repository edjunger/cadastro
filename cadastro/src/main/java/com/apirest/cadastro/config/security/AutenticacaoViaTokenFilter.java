package com.apirest.cadastro.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apirest.cadastro.document.Pessoa;
import com.apirest.cadastro.repository.CadastroRepository;



public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private CadastroRepository repository;

	public AutenticacaoViaTokenFilter(TokenService tokenService, CadastroRepository repository) {
		super();
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recupetarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		
		if(valido) {
			autenticarClient(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarClient(String token) {
		String id = tokenService.getIdUsuario(token).toString();
		Optional<Pessoa> usuario = repository.findById(id);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.get().getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recupetarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer")) {
			return null;
		}else {
			return token.substring(7, token.length());
		}
		
		
	}

}
