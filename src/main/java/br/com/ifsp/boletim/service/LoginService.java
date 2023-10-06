package br.com.ifsp.boletim.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifsp.boletim.model.LoginModel;
import br.com.ifsp.boletim.model.UsuarioModel;
import br.com.ifsp.boletim.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository loginRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public String efetuarLogin(LoginModel login) {
				
		UsuarioModel usuario = loginRepository.findByLogin(login.getLogin());
		
		if(usuario == null) {
			System.out.println("Usuário não encontrado.");
			return "login";
		}
			
		String senhaRequestCriptografada = DigestUtils.md5Hex(login.getSenha()).toUpperCase();		
		if(senhaRequestCriptografada.equals(usuario.getSenha())) {
			System.out.println("logou");
			return "redirect:/materias";
		}
		
		return "login";
	}

	public ResponseEntity<UsuarioModel> criaUsuario(UsuarioModel usuario) {		
		if(usuario.getSenha().equals(usuario.getConfirmacaoSenha())) {
			String senhaCriptografada = DigestUtils.md5Hex(usuario.getSenha()).toUpperCase();
			usuario.setSenha(senhaCriptografada);
			System.out.println(senhaCriptografada);
			System.out.println("Usuário criado.");
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UsuarioModel());
	}

}
