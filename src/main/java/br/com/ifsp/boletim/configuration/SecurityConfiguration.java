package br.com.ifsp.boletim.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.ifsp.boletim.service.CustomUserDetailService;

@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
	    	.authorizeHttpRequests()
	    	.antMatchers("/boletim/api/*")
	    	.hasAuthority("ROLE_USER")
	    	.antMatchers("/boletim/api/delete/*")
	    	.hasAuthority("ROLE_ADMIN")
	    	.and()
	    	.httpBasic()
	    	.and()
	    	.csrf()
	    	.disable();
	        return http.build();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
