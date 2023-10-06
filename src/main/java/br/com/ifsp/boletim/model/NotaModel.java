package br.com.ifsp.boletim.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "nota")
public class NotaModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNota;
	
	private String materia;
	
	private int nota;

}
