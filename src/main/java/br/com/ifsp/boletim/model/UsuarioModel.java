package br.com.ifsp.boletim.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String nome;
	
	private String sobrenome;
	
	private String login;
	
	private String senha;
	
	@Transient
	private String confirmacaoSenha;
	
		
}
