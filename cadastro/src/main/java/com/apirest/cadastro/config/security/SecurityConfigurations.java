package com.apirest.cadastro.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.apirest.cadastro.repository.CadastroRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private CadastroRepository repository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println("Senha");
	}
	
	//Configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		List<String> listaMetodos = new ArrayList<String>(); 
		listaMetodos.add("GET");
		listaMetodos.add("POST");
	    listaMetodos.add("DELETE");
	    listaMetodos.add("OPTIONS");
	    listaMetodos.add("HEAD");
	    listaMetodos.add("TRACE");
	    listaMetodos.add("CONNECT");
	    
		http.cors().configurationSource(request -> new 
			       CorsConfiguration().applyPermitDefaultValues());
		
		
		 http.authorizeRequests()
		/* .antMatchers(HttpMethod.GET, "/pessoa").permitAll()
		 .antMatchers(HttpMethod.GET, "/pessoa/*").permitAll()
		 .antMatchers(HttpMethod.POST, "/pessoa").permitAll()
		 .antMatchers(HttpMethod.POST, "/pessoa/*").permitAll()
		 .antMatchers(HttpMethod.PUT, "/pessoa").permitAll()
		 .antMatchers(HttpMethod.PUT, "/pessoa/*").permitAll()
		 .antMatchers(HttpMethod.DELETE, "/pessoa").permitAll()
		 .antMatchers(HttpMethod.DELETE, "/pessoa/*").permitAll()*/
		 .antMatchers(HttpMethod.POST, "/pessoa/conta").permitAll()
		 .antMatchers(HttpMethod.POST, "/auth").permitAll()
		 .anyRequest().authenticated()
		 .and().csrf().disable()
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
	//Configuracoes de recursos estaticos(js, css, imagens, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring()
	        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
}
