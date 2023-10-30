package br.com.ifsp.boletim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class UsuarioModel {
	
	@Id
	private int idUsuario;	
	private String usuario;
	private String login;
	private String senha;
	private boolean admin;

}
