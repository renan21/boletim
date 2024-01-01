package br.com.ifsp.boletim.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.ifsp.boletim.model.UsuarioModel;
import br.com.ifsp.boletim.repository.UsuarioRepository;

@Service
public class CustomUserDetailService implements UserDetailsManager {
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UsuarioModel usuario = Optional
    								.ofNullable(usuarioRepository.findByLogin(username))
    								.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        return User
        			.withUsername(usuario.getUsuario())
                	.password("{bcrypt}"+usuario.getSenha())
                	.roles(usuario.isAdmin() ? "ADMIN" : "USER")
                	.accountExpired(true)
                	.accountLocked(true)
                	.credentialsExpired(true)
                	.disabled(true)
                	.build();
    }
    
    //TODO: Implemente os métodos restantes da interface UserDetailsManager, se necessário

    
	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return true;
	}

}

