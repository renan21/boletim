package br.com.ifsp.boletim.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import br.com.ifsp.boletim.service.CustomUserDetailService;

@EnableWebSecurity
public class SecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

    		.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
//    												.requestMatchers("/boletim/api/*").hasRole("USER")
//    												.requestMatchers("/boletim/api/delete/*").hasRole("ADMIN"))
            .userDetailsService(customUserDetailService)
            .httpBasic(Customizer.withDefaults())
    		.csrf(csrf -> csrf.disable())
    		.cors(cors -> cors.disable());
        return http.build();
    }
        
    
}
