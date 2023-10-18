package br.com.ifsp.boletim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsp.boletim.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
	
	UsuarioModel findByLogin(String login);

}
