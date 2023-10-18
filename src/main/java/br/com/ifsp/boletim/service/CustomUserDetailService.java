package br.com.ifsp.boletim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ifsp.boletim.model.UsuarioModel;
import br.com.ifsp.boletim.repository.UsuarioRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioModel usuario = Optional
									.ofNullable(usuarioRepository.findByLogin(username))
									.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

			
		
		
		return new User(usuario.getUsuario(),
						usuario.getSenha(),
						usuario.isAdmin() ? authorityListAdmin : authorityListUser);
	}

}
